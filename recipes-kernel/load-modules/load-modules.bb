DESCRIPTION = "Load some kernel modules at boot"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://modules.conf"

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${libdir}/modules-load.d
    install -m 0644 modules.conf ${D}${libdir}/modules-load.d/50-modules.conf
}

FILES_${PN} = "${libdir}"
