HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "92e738f5556a63f14360a9a628e36eeb66c9a7bf"

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

SRC_URI = "git://git.denx.de/u-boot.git \
           file://0001-mtd-Fallback-to-_read-write_oob-when-_read-write-is-.patch \
           file://0002-mtd-Uninline-mtd_write_oob-and-move-it-to-mtdcore.c.patch \
           file://0003-mtd-Add-sanity-checks-in-mtd_write-read_oob.patch \
           file://0004-mtd-Fallback-to-_read-write-when-_read-write_oob-is-.patch \
           file://0005-mtd-add-get-set-of_node-flash_node-helpers.patch \
           file://0006-mtd-fix-build-issue-with-includes.patch \
           file://0007-mtd-move-definitions-to-enlarge-their-range.patch \
           file://0008-mtd-move-all-flash-categories-inside-MTD-submenu.patch \
           file://0009-mtd-move-NAND-files-into-a-raw-subdirectory.patch \
           file://0010-mtd-rename-nand-into-rawnand-in-Kconfig-prompt.patch \
           file://0011-mtd-nand-Add-core-infrastructure-to-deal-with-NAND-d.patch \
           file://0012-mtd-nand-Pass-mode-information-to-nand_page_io_req.patch \
           file://0013-spi-Extend-the-core-to-ease-integration-of-SPI-memor.patch \
           file://0014-mtd-nand-Add-core-infrastructure-to-support-SPI-NAND.patch \
           file://0015-mtd-spinand-Add-initial-support-for-Micron-MT29F2G01.patch \
           file://0016-mtd-spinand-Add-initial-support-for-Winbond-W25M02GV.patch \
           file://0017-mtd-spinand-Add-initial-support-for-the-MX35LF1GE4AB.patch \
           file://0018-mtd-spinand-Add-initial-support-for-the-MX35LF2GE4AB.patch \
           file://0019-dt-bindings-Add-bindings-for-SPI-NAND-devices.patch \
           file://0020-mtd-declare-MTD_PARTITIONS-symbol-in-Kconfig.patch \
           file://0021-cmd-ubi-delete-useless-and-misleading-definitions.patch \
           file://0022-cmd-mtdparts-accept-spi-nand-devices.patch \
           file://0023-cmd-mtdparts-add-a-generic-mtdparts-parser.patch \
           file://0024-cmd-mtdparts-remove-useless-mtdparts-prefix.patch \
           file://0025-mtd-uclass-add-probe-function.patch \
           file://0026-cmd-mtd-add-mtd-command.patch \
           file://0027-cmd-mtdparts-try-to-probe-the-MTD-devices-as-a-fallb.patch \
           file://0028-sf-Add-SPI_FLASH_4BYTE_MODE_ONLY-option-to-support-4.patch \
           file://0029-sf-Add-XMC-xm25qh64a-and-xm25qh128a-entries.patch \
           file://0030-common-Increase-LOGLEVEL-back-to-6.patch \
           file://0031-spi-Add-SPI-driver-for-MT76xx-SoCs.patch \
           file://0032-mips-Add-basic-MediaTek-MT7620-88-support.patch \
           file://0033-mips-Add-arch-mips-include-asm-atomic.h.patch \
           file://0034-mips-Add-LinkIt-Smart-7688-support.patch \
           file://0035-mips-Add-Gardena-Smart-Gateway-board-support.patch \
           file://0036-mips-mt76xx-Add-sysreset-support.patch \
           file://0037-mips-mt7628a.dtsi-Add-SPI-clock-frequency-property.patch \
           file://0038-mtd-nand-spi-Add-Gigadevice-SPI-NAND-support.patch \
           file://0039-spi-spi-mem-Use-2-SPI-messages-instead-of-a-single-f.patch \
           file://0040-cmd-mtd-Don-t-abort-erase-operation-when-a-bad-block.patch \
           file://0041-cmd-mtd-Don-t-use-with-negative-return-codes-for-she.patch \
           file://0042-cmd-mtd-Add-info-text-to-mtd-erase-subcommand.patch \
           file://0043-fs-ubifs-Add-missing-newlines-in-super.c.patch \
           file://0044-WIP-mips-arch-Add-ethernet-support.patch \
           file://0045-WIP-net-Add-MT76xx-ethernet-driver.patch \
           file://0046-mips-mt76xx-Add-ethernet-DT-node-to-mt7628a.dtsi.patch \
           file://0047-WIP-configs-linkit_smart_7688_defconfig-Fix-and-add-.patch \
           file://0048-WIP-configs-gardena-smart-gateway-mt7688_defconfig-A.patch \
           file://0049-WIP-drivers-net-mt76xx-eth.c.patch \
           file://0050-WIP-drivers-net-mt76xx-eth.c.patch \
           file://0051-Revert-WIP-drivers-net-mt76xx-eth.c.patch \
           file://0052-MIPS-cache-allow-jumps-in-mips_cache_reset.patch \
           file://0053-WIP-MIPS-cache-optimize-changing-of-k0-CCA-mode.patch \
           file://0054-mips-linkit-smart-7688-Use-ioremap_nocache-to-get-ad.patch \
           file://0055-mips-linkit-smart-7688-defconfig-Enable-MIPS_BOOT_CM.patch \
           file://0056-mips-gardena-smart-gateway-defconfig-Enable-MIPS_BOO.patch \
           file://0057-mips-linkit-smart-7688-Fix-linux-uart-selection-in-c.patch \
           file://0058-mips-gardena-smart-gateway-mt7688.h-Increase-malloc-.patch \
           file://0001-Enable-lzma-support-for-uImage.lzma.patch \
           file://0002-Enable-the-DHCP-command.patch \
           file://0001-Adapt-fw_env.config-to-our-layout.patch \
           "

S = "${WORKDIR}/git"
