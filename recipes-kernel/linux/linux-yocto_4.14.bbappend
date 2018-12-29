LINUX_VERSION_mt7688 =  "4.14.76"

PR = "r0"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "mt7688"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/${PN}-${PV}/${MACHINE}:"

KCONFIG_MODE = "--allnoconfig"

KERNEL_DEVICETREE_mt7688 = " \
        ralink/gardena_smart_gateway_mt7688.dtb \
        "

LINUX_VERSION_EXTENSION = "-yocto-${LINUX_KERNEL_TYPE}-${PR}"

SRC_URI_append_mt7688 = " \
        file://defconfig \
        file://enable_console.cfg \
        file://enable_debugfs.cfg \
        file://enable_devmem.cfg \
        file://enable_mediatek_gpio_support.cfg \
        file://enable_mediatek_i2c.cfg \
        file://enable_mediatek_spi_support.cfg \
        file://enable_mtd_tests.cfg \
        file://enable_ppp.cfg \
        file://enable_squashfs.cfg \
        file://enable_systemd_dependencies.cfg \
        file://enable_tun.cfg \
        file://enable_wmac.cfg \
        file://set_default_loglevel.cfg \
        file://0001-Allow-inclusion-of-DTB-in-image.patch \
        file://0002-MIPS-pci-mt7620-enabled-PCIe-on-MT7688.patch \
        file://0003-owrt-hack-fix-mt7688-cache-issue.patch \
        file://0004-mtd-nor-support-mtd-name-from-device-tree.patch \
        file://0005-mtd-nand-Check-length-of-ID-before-reading-bits-per-.patch \
        file://0006-mtd-nand-Add-JEDEC-manufacturer-ID-for-Gigadevice.patch \
        file://0007-mtd-Introduce-SPI-NAND-framework.patch \
        file://0008-mtd-spi-nand-Support-Gigadevice-GD5F.patch \
        file://0009-mtd-spi-nor-Add-support-for-XM25QH64A-and-XM25QH128A.patch \
        file://0010-Import-MediaTek-Ethernet-patches-from-OpenWrt.patch \
        file://0077-net-phy-add-phy_ethtool_ioctl.patch \
        file://0087-net-swconfig-adds-openwrt-switch-layer.patch \
        file://0088-GPIO-add-named-gpio-exports.patch \
        file://0089-pinctrl-ralink-add-pinctrl-driver.patch \
        file://0090-GPIO-ralink-add-mt7621-gpio-controller.patch \
        file://0091-SPI-ralink-add-Ralink-SoC-spi-driver.patch \
        file://0092-spi-add-mt7621-support.patch \
        file://0094-i2c-MIPS-add-mt7621-I2C-driver.patch \
        file://0095-MIPS-dts-ralink-Add-more-hardware-to-MT7628a.patch \
        file://0096-ethernet-mediatek-rt3050-fix-carrier.patch \
        file://0097-Add-support-for-GD5F1GQ4UB-NAND.patch \
        file://0098-MIPS-Add-Gardena-smart-Gateway-MT7688-board.patch \
        file://0099-mtd-spi-nor-allow-NOR-driver-to-write-fewer-bytes-th.patch \
        file://0100-add-mt7628an.dtsi-ported-from-openwrt.patch \
        file://0101-use-new-dtsi-for-soc-enable-wmac-add-spi-partitions.patch \
        file://0102-tty-serial-8250-use-mctrl_gpio-helpers.patch \
        file://0103-SG-10035-enable-hw-flow-control-on-uart2-Bluetooth.patch \
        file://0102-NET-add-mtd-mac-address-support-to-of_get_mac_addres.patch \
        file://0104-Set-pin-sharing-group-i2s-to-GPIO.patch \
        file://0300-netfilter-conntrack-cache-route-for-forwarded-connec.patch \
        file://0301-netfilter-add-defines-for-arp-decnet-max-hooks.patch \
        file://0302-netfilter-core-make-nf_unregister_net_hooks-simple-w.patch \
        file://0303-netfilter-core-remove-synchronize_net-call-if-nfqueu.patch \
        file://0304-netfilter-core-free-hooks-with-call_rcu.patch \
        file://0305-netfilter-reduce-size-of-hook-entry-point-locations.patch \
        file://0306-netfilter-reduce-hook-array-sizes-to-what-is-needed.patch \
        file://0307-netfilter-don-t-allocate-space-for-decnet-hooks-unle.patch \
        file://0308-netfilter-don-t-allocate-space-for-arp-bridge-hooks-.patch \
        file://0309-netfilter-core-pass-hook-number-family-and-device-to.patch \
        file://0310-netfilter-core-add-nf_remove_net_hook.patch \
        file://0311-netfilter-core-pass-family-as-parameter-to-nf_remove.patch \
        file://0312-netfilter-core-support-for-NFPROTO_INET-hook-registr.patch \
        file://0313-netfilter-nf_tables-explicit-nft_set_pktinfo-call-fr.patch \
        file://0314-netfilter-core-only-allow-one-nat-hook-per-hook-poin.patch \
        file://0315-netfilter-nf_tables_inet-don-t-use-multihook-infrast.patch \
        file://0316-netfilter-nf_tables-remove-multihook-chains-and-fami.patch \
        file://0317-netfilter-move-checksum-indirection-to-struct-nf_ipv.patch \
        file://0318-netfilter-move-checksum_partial-indirection-to-struc.patch \
        file://0319-netfilter-remove-saveroute-indirection-in-struct-nf_.patch \
        file://0320-netfilter-move-route-indirection-to-struct-nf_ipv6_o.patch \
        file://0321-netfilter-move-reroute-indirection-to-struct-nf_ipv6.patch \
        file://0322-netfilter-remove-route_key_size-field-in-struct-nf_a.patch \
        file://0323-netfilter-remove-struct-nf_afinfo-and-its-helper-fun.patch \
        file://0324-netfilter-nf_tables_arp-don-t-set-forward-chain.patch \
        file://0325-netfilter-nf_tables-remove-hooks-from-family-definit.patch \
        file://0326-netfilter-remove-defensive-check-on-malformed-packet.patch \
        file://0327-netfilter-meta-secpath-support.patch \
        file://0328-netfilter-conntrack-move-nf_ct_netns_-get-put-to-cor.patch \
        file://0329-netfilter-nf_conntrack-add-IPS_OFFLOAD-status-bit.patch \
        file://0330-netfilter-nf_tables-add-flow-table-netlink-frontend.patch \
        file://0331-netfilter-add-generic-flow-table-infrastructure.patch \
        file://0332-netfilter-flow-table-support-for-IPv4.patch \
        file://0333-netfilter-flow-table-support-for-IPv6.patch \
        file://0334-netfilter-flow-table-support-for-the-mixed-IPv4-IPv6.patch \
        file://0335-netfilter-nf_tables-flow-offload-expression.patch \
        file://0336-netfilter-nf_tables-remove-nhooks-field-from-struct-.patch \
        file://0337-netfilter-nf_tables-fix-a-typo-in-nf_tables_getflowt.patch \
        file://0338-netfilter-improve-flow-table-Kconfig-dependencies.patch \
        file://0339-netfilter-nf_tables-remove-flag-field-from-struct-nf.patch \
        file://0340-netfilter-nf_tables-no-need-for-struct-nft_af_info-t.patch \
        file://0341-netfilter-nf_tables-remove-struct-nft_af_info-parame.patch \
        file://0342-netfilter-nf_tables-fix-potential-NULL-ptr-deref-in-.patch \
        file://0343-netfilter-nf_tables-add-single-table-list-for-all-fa.patch \
        file://0344-netfilter-exit_net-cleanup-check-added.patch \
        file://0345-netfilter-nf_tables-get-rid-of-pernet-families.patch \
        file://0346-netfilter-nf_tables-get-rid-of-struct-nft_af_info-ab.patch \
        file://0347-netfilter-nft_flow_offload-wait-for-garbage-collecto.patch \
        file://0348-netfilter-nft_flow_offload-no-need-to-flush-entries-.patch \
        file://0349-netfilter-nft_flow_offload-move-flowtable-cleanup-ro.patch \
        file://0350-netfilter-nf_tables-fix-flowtable-free.patch \
        file://0351-netfilter-nft_flow_offload-handle-netdevice-events-f.patch \
        file://0352-netfilter-nf_tables-allocate-handle-and-delete-objec.patch \
        file://0353-netfilter-nf_flow_offload-fix-use-after-free-and-a-r.patch \
        file://0354-netfilter-flowtable-infrastructure-depends-on-NETFIL.patch \
        file://0355-netfilter-remove-duplicated-include.patch \
        file://0356-netfilter-nf_flow_table-use-IP_CT_DIR_-values-for-FL.patch \
        file://0357-netfilter-nf_flow_table-clean-up-flow_offload_alloc.patch \
        file://0358-netfilter-nf_flow_table-cache-mtu-in-struct-flow_off.patch \
        file://0359-netfilter-nf_flow_table-rename-nf_flow_table.c-to-nf.patch \
        file://0360-netfilter-nf_flow_table-move-ipv4-offload-hook-code-.patch \
        file://0361-netfilter-nf_flow_table-move-ip-header-check-out-of-.patch \
        file://0362-netfilter-nf_flow_table-move-ipv6-offload-hook-code-.patch \
        file://0363-netfilter-nf_flow_table-relax-mixed-ipv4-ipv6-flowta.patch \
        file://0364-netfilter-nf_flow_table-move-init-code-to-nf_flow_ta.patch \
        file://0365-netfilter-nf_flow_table-fix-priv-pointer-for-netdev-.patch \
        file://0366-netfilter-nf_flow_table-track-flow-tables-in-nf_flow.patch \
        file://0367-netfilter-nf_flow_table-make-flow_offload_dead-inlin.patch \
        file://0368-netfilter-nf_flow_table-add-a-new-flow-state-for-tea.patch \
        file://0369-netfilter-nf_flow_table-in-flow_offload_lookup-skip-.patch \
        file://0370-netfilter-nf_flow_table-add-support-for-sending-flow.patch \
        file://0371-netfilter-nf_flow_table-tear-down-TCP-flows-if-RST-o.patch \
        file://0372-netfilter-nf_flow_table-fix-checksum-when-handling-D.patch \
        file://0373-netfilter-nf_flow_table-clean-up-and-fix-dst-handlin.patch \
        file://0374-netfilter-nf_flow_table-add-missing-condition-for-TC.patch \
        file://0375-netfilter-nf_flow_table-fix-offloading-connections-w.patch \
        file://0376-netfilter-nf_flow_table-attach-dst-to-skbs.patch \
        file://0377-netfilter-nf_flow_table-fix-offloaded-connection-tim.patch \
        file://0378-netfilter-nf_flow_table-fix-up-ct-state-of-flows-aft.patch \
        "
