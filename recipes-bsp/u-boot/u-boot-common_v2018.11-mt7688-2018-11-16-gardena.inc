HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "2"
INC_PR  = "r1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "011b4c0d56f1da79083557543b70eec2cbc8b40d"

UBOOT_LOCALVERSION ?= "-yocto"

SRC_URI = " \
    git://github.com/husqvarnagroup/smart-garden-u-boot.git;protocol=https;branch=v2018.11-mt7688-2018-11-16-gardena \
    file://fw_env.config \
"

S = "${WORKDIR}/git"
