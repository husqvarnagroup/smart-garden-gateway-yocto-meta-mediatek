LINUX_VERSION_mt7620 =  "4.12.21"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "mt7620"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/${PN}-${PV}/${MACHINE}:"

KBRANCH_mt7620 ?= "standard/base"

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE_mt7620 = " \
		ralink/mt7620a_eval.dtb \
		"

SRC_URI_append_mt7620 = " \
		file://0002-pci-mt7620.c-Use-KERN_WARNING.patch;name=patch002 \
		file://0003-Allow-inclusion-of-DTB-in-image.patch \
		file://defconfig \
		"

SRC_URI[patch001.md5sum] = "924b6f7a3c151116192a471ac5b2be23"
SRC_URI[patch002.md5sum] = "f73b6db0e41d0bec9083cb4aeea70a39"
SRC_URI[defconfig.md5sum] = "a69bdbf1361a13e9d5939994bfaccd13"

# KERNEL_FEATURES_append_mt7620 = ""
