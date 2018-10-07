HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"
INC_PR  = "r2"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "a0b432419cdb5ab1a4be2b246783cec5d3f0c776"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://stash.dss.husqvarnagroup.com/scm/sg/smart-garden-u-boot.git;protocol=https;branch=v2018.11-rc1-mt7688-2018-10-04-gardena \
    file://fw_env.config \
"

S = "${WORKDIR}/git"
