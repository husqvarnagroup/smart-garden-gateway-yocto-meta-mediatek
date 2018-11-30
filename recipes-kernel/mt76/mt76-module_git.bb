SUMMARY = "mt76 Wireless Driver"
LICENSE = "ISC & Proprietary"
# part of GPL license from used source code
# firmware has own license
LIC_FILES_CHKSUM = "file://mt7603/main.c;endline=16;md5=623d46335153100b0f7c1ffbe55d6c18 \
                    file://firmware/LICENSE;md5=1bff2e28f0929e483370a43d4d8b6f8e"

inherit module

BRANCH = "master"

SRC_URI = "\
    git://github.com/openwrt/mt76.git;protocol=https;branch=${BRANCH} \
    file://0001-add-missing-actions-to-Makefile.patch \
    file://mt76-backport.patch \
"
SRCREV = "5a5b396e6edee22e7aaf7743c961473714f205b9"
PV = "1.0+git${SRCPV}"
PR = "r2"

S = "${WORKDIR}/git"

DEPENDS += "bc-native"

EXTRA_OEMAKE += "CONFIG_MT7603E=m"

KERNEL_MODULE_AUTOLOAD += "kernel-module-mt7603e"

RPROVIDES_${PN} += "kernel-module-mt7603e"
PACKAGES =+ "linux-firmware-mt7628"

do_install_append () {
	install -d  ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e1.bin ${D}${base_libdir}/firmware/
	install -m 0644 ${S}/firmware/mt7628_e2.bin ${D}${base_libdir}/firmware/
}

FILES_linux-firmware-mt7628 = "${base_libdir}/firmware/mt7628*"
