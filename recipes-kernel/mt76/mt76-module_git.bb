SUMMARY = "mt76 Wireless Driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=36cf660aea2b8beffba7945f44a7e748"

inherit module

BRANCH = "openwrt-18.06"

SRC_URI = "git://github.com/openwrt/mt76.git;protocol=https;branch=${BRANCH} \
            file://0001-add-missing-actions-to-Makefile.patch"

SRCREV = "53e1110a354576210b60012cccd5d77af219c60d"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS += "bc-native"

KERNEL_MODULE_AUTOLOAD += "kernel-module-mt7603e"

RPROVIDES_${PN} += "kernel-module-mt7603e"
PACKAGES =+ "linux-firmware-mt7628"
#RDEPENDS_${PN} += "linux-firmware-mt76"

do_install_append () {
	install -d  ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e1.bin ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e2.bin ${D}${base_libdir}/firmware/
}

FILES_linux-firmware-mt7628 = "${base_libdir}/firmware/mt7628*"
