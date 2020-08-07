KBRANCH ?= "v4.19/standard/tiny/base"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "4.19.78"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine ?= "a915fbeae8ed987402f69666d90bef15a01c5823"
SRCREV_meta ?= "ad6f8b357720ca8167a090713b7746230cf4b314"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "${INC_PR}.3"

SRC_URI_mt7688 = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
                  git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA} \
                  file://0001-pinctrl-ralink-add-pinctrl-driver.patch \
                  file://0002-spi-add-mt7621-support.patch \
                  file://0003-i2c-add-mt7621-driver-new-enhanced-driver.patch \
                  file://0004-MIPS-ralink-dts-mt7628a.dtsi-Add-more-hardware-to-MT.patch \
                  file://0005-MIPS-ralink-dts-Add-mt7628an.dtsi-ported-from-openwr.patch \
                  file://0006-MIPS-ralink-dts-mt7628an.dtsi-Add-cpu-device_type.patch \
                  file://0007-MIPS-ralink-dts-mt7628an.dtsi-Add-GPIO-compatible-pr.patch \
                  file://0008-MIPS-ralink-dts-Add-Gardena-smart-Gateway-MT7688-boa.patch \
                  file://0009-MIPS-defconfig-Add-gardena-smart-gateway_defconfig.patch \
                  file://0010-watchdog-mt7621-Include-of.h-to-fix-compile-breakage.patch \
                  file://0011-Revert-net-ethernet-mediatek-Use-NET_IP_ALIGN-to-jud.patch \
                  file://0012-Revert-net-ethernet-mediatek-Use-hw_feature-to-judge.patch \
                  file://0013-OpenWrt-net-Import-MediaTek-Ethernet-patches-from-Op.patch \
                  file://0014-OpenWrt-net-phy-add-phy_ethtool_ioctl.patch \
                  file://0015-net-ethernet-mediatek-mtk_eth_soc-Set-DMA-masks.patch \
                  file://0016-net-ethernet-mediatek-rt3050-fix-carrier.patch \
                  file://0017-mtd-spinand-Add-Gigadevice-SPI-NAND-support.patch \
                  file://0018-spi-mt7621-Update-SPI-driver-code-to-the-old-SPI-NAN.patch \
                  file://0019-spi-mt7621-Use-only-one-SPI-transfer-function-for-bo.patch \
                  file://0020-tty-serial-8250-use-mctrl_gpio-helpers.patch \
                  file://0021-MIPS-ralink-dts-gardena_smart_gateway_mt7688.dts-SG-.patch \
                  file://0022-Revert-gpio-MT7621-use-a-per-instance-irq_chip-struc.patch \
                  file://0023-Revert-gpio-mt7621-pass-mediatek_gpio_bank_probe-fai.patch \
                  file://0024-Revert-gpio-mt7621-report-failure-of-devm_kasprintf.patch \
                  file://0025-gpio-gpio-mt7621-Use-old-GPIO-driver-from-OpenWrt-4..patch \
                  file://0026-WIP-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add.patch \
                  file://0027-drivers-misc-add-U-Boot-bootcount-driver-enhanced-ve.patch \
                  file://0028-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-boo.patch \
                  file://0029-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-eth.patch \
                  file://0030-WIP-HACK-tty-serial-8250-Call-serial8250_enable_ms-f.patch \
                  file://0031-WIP-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Set.patch \
                  file://0032-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-res.patch \
                  file://0033-MIPS-gardena-smart-gateway_defconfig-Enable-INPUT_EV.patch \
                  file://0034-mtd-spinand-Copy-GigaDevice-support-from-latest-v5.0.patch \
                  file://0035-spi-mt7621-Move-SPI-driver-out-of-staging.patch \
                  file://0036-i2c-mt7621-Configure-controller-pins-to-open-drain-i.patch \
                  file://0037-net-phy-Remove-reference-to-non-existing-b53-driver.patch \
                  file://0038-MIPS-ralink-Add-missing-include.patch \
                  file://0039-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Limit-U.patch \
                  "

COMPATIBLE_MACHINE = "mt7688"

# Functionality flags
KERNEL_FEATURES = ""

# Hardware specific settings
SRC_URI_append_mt7688 = "\
    file://defconfig \
    file://enable_ethernet.cfg \
    file://enable_mediatek_gpio_support.cfg \
    file://enable_mediatek_i2c.cfg \
    file://enable_mediatek_spi_support.cfg \
    file://enable_modules.cfg \
    file://enable_serial.cfg \
    file://enable_wmac.cfg \
    file://set_default_hostname.cfg \
"
