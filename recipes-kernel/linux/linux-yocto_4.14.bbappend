LINUX_VERSION_mt7688 =  "4.14.30"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "mt7688"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/${PN}-${PV}/${MACHINE}:"

# KBRANCH_mt7688 ?= "standard/base"

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE_mt7688 = " \
        ralink/omega2p.dtb \
        "

SRC_URI_append_mt7688 = " \
        file://defconfig \
        file://0003-Allow-inclusion-of-DTB-in-image.patch \
        file://0009-PCI-MIPS-enable-PCIe-on-MT7688.patch \
        file://0013-owrt-hack-fix-mt7688-cache-issue.patch \
        file://401-mtd-nor-support-mtd-name-from-device-tree.patch \
        file://411-mtd-nand-Check-length-of-ID-before-reading-bits-per-.patch \
        file://412-mtd-nand-Add-JEDEC-manufacturer-ID-for-Gigadevice.patch \
        file://413-mtd-Introduce-SPI-NAND-framework.patch \
        file://414-mtd-spi-nand-Support-Gigadevice-GD5F.patch \
        "

# KERNEL_FEATURES_append_mt7688 = ""
