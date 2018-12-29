FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR_append = ".0"

SRC_URI_append = "\
        file://enable_devmem.cfg \
"
