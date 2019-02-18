HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "2"
INC_PR  = "r1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "d3f486c134ad0c6b38476ddbd9c756bde3cb2d11"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://stash.dss.husqvarnagroup.com/scm/sg/smart-garden-u-boot.git;protocol=https;branch=v2018.11-mt7688-2018-11-29-gardena \
    file://fw_env.config \
"

S = "${WORKDIR}/git"
