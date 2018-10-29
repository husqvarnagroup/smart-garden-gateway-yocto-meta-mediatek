SUMMARY = "mt76 Wireless Driver"
LICENSE = "GPLv2"
# part of GPL license from used source code
# firmware has own license
LIC_FILES_CHKSUM = "file://mt7603_main.c;endline=15;md5=c09518d7c19245488c97df089f53ad0b \
                    file://firmware/LICENSE;md5=1bff2e28f0929e483370a43d4d8b6f8e"

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

do_install_append () {
	install -d  ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e1.bin ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e2.bin ${D}${base_libdir}/firmware/
}

FILES_linux-firmware-mt7628 = "${base_libdir}/firmware/mt7628*"
