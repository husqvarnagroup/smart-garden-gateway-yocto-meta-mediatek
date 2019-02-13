KBRANCH ?= "v4.19/standard/tiny/base"
KBRANCH_qemuarm  ?= "v4.19/standard/tiny/arm-versatile-926ejs"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "4.19.19"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine_qemuarm ?= "64017daf053fdb31049248e45f42e0abd55117d3"
SRCREV_machine ?= "ad24af0809e17882e33fb4bd77426e691f47b46d"
SRCREV_meta ?= "4c0da29403e242f3d429196cf4a03200211e6ff4"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA}"

COMPATIBLE_MACHINE = "qemux86|qemux86-64|qemuarm"

# Functionality flags
KERNEL_FEATURES = ""

KERNEL_DEVICETREE_qemuarm = "versatile-pb.dtb"

COMPATIBLE_MACHINE = "mt7688"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR = "r0"

LINUX_VERSION_EXTENSION = "-${LINUX_KERNEL_TYPE}-${PR}"

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
    file://0001-pinctrl-ralink-add-pinctrl-driver.patch \
    file://0002-spi-add-mt7621-support.patch \
    file://0003-i2c-add-mt7621-driver-new-enhanced-driver.patch \
    file://0004-MIPS-ralink-dts-mt7628a.dtsi-Add-more-hardware-to-MT.patch \
    file://0005-MIPS-ralink-dts-Add-mt7628an.dtsi-ported-from-openwr.patch \
    file://0006-MIPS-ralink-dts-mt7628an.dtsi-Add-cpu-device_type.patch \
    file://0007-MIPS-ralink-dts-mt7628an.dtsi-Add-GPIO-compatible-pr.patch \
    file://0008-MIPS-ralink-dts-Add-Gardena-smart-Gateway-MT7688-boa.patch \
    file://0010-OOT-MIPS-gardena-smart-gateway-Add-its-file-to-gener.patch \
    file://0011-OOT-MIPS-gardena-smart-gateway-Add-script-to-help-bu.patch \
    file://0012-watchdog-mt7621-Include-of.h-to-fix-compile-breakage.patch \
    file://0013-OpenWrt-net-Import-MediaTek-Ethernet-patches-from-Op.patch \
    file://0014-OpenWrt-net-phy-add-phy_ethtool_ioctl.patch \
    file://0015-net-ethernet-mediatek-mtk_eth_soc-Set-DMA-masks.patch \
    file://0016-net-ethernet-mediatek-rt3050-fix-carrier.patch \
    file://0017-mtd-spinand-Add-Gigadevice-SPI-NAND-support.patch \
    file://0018-spi-mt7621-Update-SPI-driver-code-to-the-old-SPI-NAN.patch \
    file://0019-spi-mt7621-Use-only-one-SPI-transfer-function-for-bo.patch \
    file://0020-tty-serial-8250-use-mctrl_gpio-helpers.patch \
    file://0021-MIPS-ralink-dts-gardena_smart_gateway_mt7688.dts-SG-.patch \
    file://0022-gpio-gpio-mt7621-Use-old-GPIO-driver-from-OpenWrt-4..patch \
    file://0023-WIP-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add.patch \
    file://0024-MIPS-ralink-Select-CONFIG_CPU_MIPSR2_IRQ_VI-on-MT762.patch \
    file://0025-drivers-misc-add-U-Boot-bootcount-driver-enhanced-ve.patch \
    file://0026-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-boo.patch \
    file://0027-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-eth.patch \
    file://0028-Remove-reference-to-b53.patch \
    file://0029-MIPS-ralink-Add-missing-include-for-do_div.patch \
    file://0030-MIPS-ralink-Enable-SYS_SUPPORTS_ZBOOT.patch \
    file://0031-Add-GARDENA-smart-Gateway-mt7688-DTS-option.patch \
    file://0032-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Keep-st.patch \
    file://0033-WIP-HACK-tty-serial-8250-Call-serial8250_enable_ms-f.patch \
    file://0033-MIPS-ralink-dts-gardena_smart_gateway_mt7688-Add-res.patch \
    file://0034-mtd-spinand-Handle-the-case-where-PROGRAM-LOAD-does-.patch \
    file://0035-mtd-spinand-Copy-GigaDevice-support-from-latest-v5.0.patch \
"

# Distribution specific settings
# TODO: Move to distribution layer
SRC_URI_append_mt7688 += "\
    file://enable_compaction.cfg \
    file://enable_console.cfg \
    file://enable_debugfs.cfg \
    file://enable_devmem.cfg \
    file://enable_executable_format_elf.cfg \
    file://enable_executable_format_script.cfg \
    file://enable_keyboard_button.cfg \
    file://enable_leds.cfg \
    file://enable_modules.cfg \
    file://enable_mtd_tests.cfg \
    file://enable_nfsroot.cfg \
    file://enable_notify.cfg \
    file://enable_panic_on_oops.cfg \
    file://enable_ppp.cfg \
    file://enable_rfkill.cfg \
    file://enable_shmem.cfg \
    file://enable_squashfs.cfg \
    file://enable_sysrq.cfg \
    file://enable_systemd_cpuquota.cfg \
    file://enable_systemd_cpushare.cfg \
    file://enable_systemd_requirements.cfg \
    file://enable_systemd_strongly_recommended.cfg \
    file://enable_systemd_undocumented.cfg \
    file://enable_tun.cfg \
    file://enable_ubi.cfg \
    file://enable_watchdog.cfg \
    file://enable_wifi_crda.cfg \
    file://set_cfq_scheduler.cfg \
    file://set_default_loglevel.cfg \
    file://disable_kernel_samples.cfg \
"

# Misc stuff (maybe not even strictly required)
SRC_URI_append_mt7688 += "\
    file://enable_misc_stuff.cfg \
"