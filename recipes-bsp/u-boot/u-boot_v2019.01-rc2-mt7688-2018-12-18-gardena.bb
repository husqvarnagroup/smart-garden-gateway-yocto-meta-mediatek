require u-boot-common_${PV}.inc
require recipes-bsp/u-boot/u-boot.inc

PR = "${INC_PR}.1"

DEPENDS += "bc-native dtc-native"

SRC_URI += "file://0001-add-config-to-set-bootdelay-to-0.patch"
