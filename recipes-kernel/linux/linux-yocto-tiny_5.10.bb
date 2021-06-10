KBRANCH ?= "v5.10/standard/tiny/base"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.10.42"

FILESEXTRAPATHS_prepend := "${THISDIR}:${THISDIR}/${BPN}-${LINUX_VERSION}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine ?= "f09a5c524d12166be99bf465e3c0431d3aec80f2"
SRCREV_meta ?= "422f8a09a856800f027bbae98dbab24cf3ae0f25"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "${INC_PR}.0"

SRC_URI_mt7688 = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
                  git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=${KMETA} \
                  file://0001-drivers-misc-add-U-Boot-bootcount-driver-enhanced-ve.patch \
                  file://0002-WIP-HACK-tty-serial-8250-Call-serial8250_enable_ms-f.patch \
                  file://0003-WIP-dtsi-mt7628a.dtsi-Add-ethernet-and-ESW-nodes.patch \
                  file://0004-WIP-gardena-Add-ethernet-and-ESW-DT-nodes.patch \
                  file://0005-WIP-net-DSA-MT7628-88-switch-driver.patch \
                  file://0006-WIP-net-DSA-mt7628-esw-Update-to-new-get_tag_protoco.patch \
                  file://0007-WIP-net-DSA-mt7628-esw-Improve-comments-variable-nam.patch \
                  file://0008-WIP-net-DSA-mt7628-esw-Use-dsa_is_user_port-helpers-.patch \
                  file://0009-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-boo.patch \
                  file://0010-dt-bindings-net-mediatek-Support-custom-ifname.patch \
                  file://0011-net-ethernet-mtk_eth_soc-Support-custom-ifname.patch \
                  file://0012-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Keep-et.patch \
                  file://0013-gpio-mt7621-Assign-base-field-in-gpio_chip.patch \
                  file://0014-mtd-spi-nor-Add-support-for-XM25QH64C.patch \
                  file://0015-mtd-spinand-gigadevice-Support-GD5F1GQ5UExxG.patch \
"

COMPATIBLE_MACHINE = "mt7688"

# Functionality flags
KERNEL_FEATURES = ""

# Hardware specific settings
SRC_URI_append_mt7688 = "\
    file://defconfig \
"
