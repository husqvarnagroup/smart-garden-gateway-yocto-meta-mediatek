require u-boot-common_${PV}.inc
require recipes-bsp/u-boot/u-boot.inc

PR = "${INC_PR}.0"

DEPENDS += "bc-native dtc-native"

