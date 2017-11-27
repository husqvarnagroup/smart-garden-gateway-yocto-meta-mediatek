require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "mt7620"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_mt7620 = " \
	ralink/PSC03.dtb \
 "

LINUX_VERSION = "4.4"
LINUX_VERSION_EXTENSION = "-inwido"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-openwrt-4.4:"

S = "${WORKDIR}/git"

PR = "r0"

PV = "4.4.14"
SRCREV = "${AUTOREV}"
SRC_URI = " \
    git://github.com/InwidoConnect/linux-openwrt.git;protocol=https \
    file://defconfig \
 "
