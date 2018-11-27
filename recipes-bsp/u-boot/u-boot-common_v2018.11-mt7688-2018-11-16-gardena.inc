HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "2"
INC_PR  = "r3"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "ed91923abf461467a4f193b75285f4bc73949e90"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://stash.dss.husqvarnagroup.com/scm/sg/smart-garden-u-boot.git;protocol=https;branch=v2018.11-mt7688-2018-11-16-gardena \
    file://0001-Add-watchdogless-Gardena-defconfigs.patch \
    file://fw_env.config \
"

S = "${WORKDIR}/git"
