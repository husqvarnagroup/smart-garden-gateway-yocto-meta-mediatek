KBRANCH ?= "v5.10/standard/tiny/base"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.10.99"

FILESEXTRAPATHS:prepend := "${THISDIR}:${THISDIR}/${BPN}-${LINUX_VERSION}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine ?= "317635e1feaecfd8aa29bc94d8d03ba873190414"
SRCREV_meta ?= "b53e11ea46f4e78ff4cb48532a11e1dbad7939b1"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "${INC_PR}.0"

SRC_URI:mt7688 = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
                  git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=${KMETA} \
                  file://0001-sg-noup-drivers-misc-add-U-Boot-bootcount-driver-enh.patch \
                  file://0002-sg-temphack-tty-serial-8250-Call-serial8250_enable_m.patch \
                  file://0003-sg-nohup-MIPS-ralink-mt7628a.dtsi-Add-ethernet-and-E.patch \
                  file://0004-sg-nohup-MIPS-ralink-dts-gardena_smart_gateway_mt768.patch \
                  file://0005-sg-noup-MIPS-ralink-dts-gardena_smart_gateway_mt7688.patch \
                  file://0006-sg-noup-gpio-mt7621-Assign-base-field-in-gpio_chip.patch \
                  file://0007-sg-toup-mtd-spi-nor-Add-support-for-XM25QH64C.patch \
                  file://0008-sg-toup-mtd-spinand-gigadevice-Support-GD5F1GQ5UExxG.patch \
                  file://0009-sg-noup-net-swconfig-adds-openwrt-switch-layer.patch \
                  file://0010-sg-noup-Import-OpenWRT-Ethernet-switch-drivers.patch \
                  file://0011-sg-noup-net-ethernet-ralink-mtk_eth_soc-Set-DMA-mask.patch \
                  file://0012-sg-noup-net-ethernet-ralink-rt3050-fix-carrier.patch \
                  file://defconfig \
"

COMPATIBLE_MACHINE = "mt7688"

# Functionality flags
KERNEL_FEATURES = ""
