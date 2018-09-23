HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"
INC_PR  = "r0"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "54847a5a798dc4c0d54df8751d2cf7d9972dc191"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://stash.dss.husqvarnagroup.com/scm/sg/smart-garden-u-boot.git;protocol=https;branch=v2018.09-rc3-mt7688-2018-09-07-gardena \
    file://fw_env.config \
    file://uEnv.txt \
"

S = "${WORKDIR}/git"
