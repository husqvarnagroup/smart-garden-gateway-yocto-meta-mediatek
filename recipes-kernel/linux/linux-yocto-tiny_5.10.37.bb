KBRANCH ?= "v5.10/standard/tiny/base"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.10.37"

FILESEXTRAPATHS_prepend := "${THISDIR}:${THISDIR}/${BPN}-${LINUX_VERSION}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine ?= "3e27efe3e870d43df01e9a9fdb06bf4221e82b51"
SRCREV_meta ?= "cd049697e9b2d3e9118110d476075ff8f87202cc"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "${INC_PR}.0"

SRC_URI_mt7688 = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
                  git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=${KMETA} \
                  file://0001-drivers-misc-add-U-Boot-bootcount-driver-enhanced-ve.patch \
                  file://0002-WIP-HACK-tty-serial-8250-Call-serial8250_enable_ms-f.patch \
                  file://0003-WIP-dtsi-mt7628a.dtsi-Add-ethernet-and-ESW-nodes.patch \
                  file://0004-WIP-gardena-Add-ethernet-and-ESW-DT-nodes.patch \
                  file://0005-WIP-net-DSA-MT7628-88-switch-driver.patch \
                  file://0006-WIP-net-DSA-mt7628-esw-Report-link-also-on-CPU-port-.patch \
                  file://0007-WIP-net-DSA-mt7628-esw-Update-to-new-get_tag_protoco.patch \
                  file://0008-WIP-net-DSA-mt7628-esw-Improve-comments-variable-nam.patch \
                  file://0009-net-DSA-mt7628-esw-Don-t-return-with-ENODEV-in-port_.patch \
"

COMPATIBLE_MACHINE = "mt7688"

# Functionality flags
KERNEL_FEATURES = ""

# Hardware specific settings
SRC_URI_append_mt7688 = "\
    file://defconfig \
"
