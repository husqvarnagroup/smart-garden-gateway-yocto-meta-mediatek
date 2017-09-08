LINUX_VERSION_mt7620 = "4.10.17"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "mt7620"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/${PN}-${PV}/${MACHINE}:"

KBRANCH_mt7620 ?= "standard/base"

# SRCREV_machine_mt7620 ?= "b442c964432938cbe10c4cc578260353045af980"

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE_mt7620 = " \
		ralink/mt7620a_eval.dtb \
		"

KERNEL_DEVICETREE_badmt7620 = " \
		ArcherC20i-kernel.bin.dtb \
		ArcherC50-kernel.bin.dtb \
		ex2700-kernel.bin.dtb \
		mt7620a-kernel.bin.dtb \
		mt7620a_mt7530-kernel.bin.dtb \
		mt7620a_mt7610e-kernel.bin.dtb \
		mt7620a_v22sg-kernel.bin.dtb \
		zbt-we826-kernel.bin.dtb \
		"

SRC_URI_append_mt7620 = " \
		file://0002-pci-mt7620.c-Use-KERN_WARNING.patch;name=patch002 \
		file://defconfig \
		"

#		file://0001-mt7620-defconfig.patch;name=patch001 \
#
SRC_URI[patch001.md5sum] = "924b6f7a3c151116192a471ac5b2be23"
SRC_URI[patch002.md5sum] = "f73b6db0e41d0bec9083cb4aeea70a39"
SRC_URI[defconfig.md5sum] = "a69bdbf1361a13e9d5939994bfaccd13"

COMPATIBLE_MACHINE = "mt7620"

# KBUILD_DEFCONFIG_mt7620 = ""

KERNEL_FEATURES_append_mt7620 = ""

LOG = "/home/ulf/mediatek.log"

do_xclean () {
	echo	BPN=${BPN}		>>	${LOG}
	echo	PN=${PN}		>>	${LOG}
	echo	PV=${PV}		>>	${LOG}
	echo	THISDIR=${THISDIR}	>>	${LOG}
	echo	MACHINE=${MACHINE}	>>	${LOG}
	echo	LINUX_VERSION=${LINUX_VERSION}	>>	${LOG}
	cat	${LOG}
}

