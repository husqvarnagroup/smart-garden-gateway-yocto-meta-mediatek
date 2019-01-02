HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "2"
INC_PR  = "r1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "b62f2be5103b2573a9f0bcab0c715719db6fab04"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://stash.dss.husqvarnagroup.com/scm/sg/smart-garden-u-boot.git;protocol=https;branch=v2019.01-rc2-mt7688-2018-12-18-gardena \
    file://0001-Add-watchdogless-Gardena-defconfigs.patch \
    file://fw_env.config \
"

S = "${WORKDIR}/git"
