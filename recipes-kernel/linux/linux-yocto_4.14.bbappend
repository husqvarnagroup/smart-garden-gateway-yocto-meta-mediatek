LINUX_VERSION_mt7688 =  "4.14.30"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "mt7688"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/${PN}-${PV}/${MACHINE}:"

# KBRANCH_mt7688 ?= "standard/base"

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE_mt7688 = " \
        ralink/gardena_smart_gateway_mt7688.dtb \
        "

SRC_URI_append_mt7688 = " \
        file://defconfig \
        file://0001-Allow-inclusion-of-DTB-in-image.patch \
        file://0002-MIPS-pci-mt7620-enabled-PCIe-on-MT7688.patch \
        file://0003-owrt-hack-fix-mt7688-cache-issue.patch \
        file://0004-mtd-nor-support-mtd-name-from-device-tree.patch \
        file://0005-mtd-nand-Check-length-of-ID-before-reading-bits-per-.patch \
        file://0006-mtd-nand-Add-JEDEC-manufacturer-ID-for-Gigadevice.patch \
        file://0007-mtd-Introduce-SPI-NAND-framework.patch \
        file://0008-mtd-spi-nand-Support-Gigadevice-GD5F.patch \
        file://0009-mtd-spi-nor-Add-support-for-XM25QH64A-and-XM25QH128A.patch \
        file://0010-MIPS-Add-Gardena-smart-Gateway-MT7688-board.patch \
        file://0011-SG-8509-Import-MediaTek-Ethernet-patches-from-OpenWr.patch \
        file://0012-netfilter-conntrack-cache-route-for-forwarded-connec.patch \
        file://0013-netfilter-nf_tables-explicit-nft_set_pktinfo-call-fr.patch \
        file://0014-netfilter-core-only-allow-one-nat-hook-per-hook-poin.patch \
        file://0015-netfilter-nf_tables_inet-don-t-use-multihook-infrast.patch \
        file://0016-netfilter-nf_tables-remove-multihook-chains-and-fami.patch \
        file://0017-netfilter-move-checksum-indirection-to-struct-nf_ipv.patch \
        file://0018-netfilter-move-checksum_partial-indirection-to-struc.patch \
        file://0019-netfilter-remove-saveroute-indirection-in-struct-nf_.patch \
        file://0020-netfilter-move-route-indirection-to-struct-nf_ipv6_o.patch \
        file://0021-netfilter-move-reroute-indirection-to-struct-nf_ipv6.patch \
        file://0022-netfilter-remove-route_key_size-field-in-struct-nf_a.patch \
        file://0023-netfilter-remove-struct-nf_afinfo-and-its-helper-fun.patch \
        file://0024-netfilter-nf_tables_arp-don-t-set-forward-chain.patch \
        file://0025-netfilter-nf_tables-remove-hooks-from-family-definit.patch \
        file://0026-netfilter-remove-defensive-check-on-malformed-packet.patch \
        file://0027-netfilter-meta-secpath-support.patch \
        file://0028-netfilter-conntrack-move-nf_ct_netns_-get-put-to-cor.patch \
        file://0029-netfilter-nf_conntrack-add-IPS_OFFLOAD-status-bit.patch \
        file://0030-netfilter-nf_tables-add-flow-table-netlink-frontend.patch \
        file://0031-netfilter-add-generic-flow-table-infrastructure.patch \
        file://0032-netfilter-flow-table-support-for-IPv4.patch \
        file://0033-netfilter-flow-table-support-for-IPv6.patch \
        file://0034-netfilter-flow-table-support-for-the-mixed-IPv4-IPv6.patch \
        file://0035-netfilter-nf_tables-flow-offload-expression.patch \
        file://0036-netfilter-nf_tables-remove-nhooks-field-from-struct-.patch \
        file://0037-netfilter-nf_tables-fix-a-typo-in-nf_tables_getflowt.patch \
        file://0038-netfilter-improve-flow-table-Kconfig-dependencies.patch \
        file://0039-netfilter-nf_tables-remove-flag-field-from-struct-nf.patch \
        file://0040-netfilter-nf_tables-no-need-for-struct-nft_af_info-t.patch \
        file://0041-netfilter-nf_tables-remove-struct-nft_af_info-parame.patch \
        file://0042-netfilter-nf_tables-fix-potential-NULL-ptr-deref-in-.patch \
        file://0043-netfilter-nf_tables-add-single-table-list-for-all-fa.patch \
        file://0044-netfilter-exit_net-cleanup-check-added.patch \
        file://0045-netfilter-nf_tables-get-rid-of-pernet-families.patch \
        file://0046-netfilter-nf_tables-get-rid-of-struct-nft_af_info-ab.patch \
        file://0047-netfilter-nft_flow_offload-wait-for-garbage-collecto.patch \
        file://0048-netfilter-nft_flow_offload-no-need-to-flush-entries-.patch \
        file://0049-netfilter-nft_flow_offload-move-flowtable-cleanup-ro.patch \
        file://0050-netfilter-nf_tables-fix-flowtable-free.patch \
        file://0051-netfilter-nft_flow_offload-handle-netdevice-events-f.patch \
        file://0052-netfilter-nf_tables-allocate-handle-and-delete-objec.patch \
        file://0053-netfilter-nf_flow_offload-fix-use-after-free-and-a-r.patch \
        file://0054-netfilter-flowtable-infrastructure-depends-on-NETFIL.patch \
        file://0055-netfilter-remove-duplicated-include.patch \
        file://0056-netfilter-nf_flow_table-use-IP_CT_DIR_-values-for-FL.patch \
        file://0057-netfilter-nf_flow_table-clean-up-flow_offload_alloc.patch \
        file://0058-netfilter-nf_flow_table-cache-mtu-in-struct-flow_off.patch \
        file://0059-netfilter-nf_flow_table-rename-nf_flow_table.c-to-nf.patch \
        file://0060-netfilter-nf_flow_table-move-ipv4-offload-hook-code-.patch \
        file://0061-netfilter-nf_flow_table-move-ip-header-check-out-of-.patch \
        file://0062-netfilter-nf_flow_table-move-ipv6-offload-hook-code-.patch \
        file://0063-netfilter-nf_flow_table-relax-mixed-ipv4-ipv6-flowta.patch \
        file://0064-netfilter-nf_flow_table-move-init-code-to-nf_flow_ta.patch \
        file://0065-netfilter-nf_flow_table-fix-priv-pointer-for-netdev-.patch \
        file://0066-netfilter-nf_flow_table-track-flow-tables-in-nf_flow.patch \
        file://0067-netfilter-nf_flow_table-make-flow_offload_dead-inlin.patch \
        file://0068-netfilter-nf_flow_table-add-a-new-flow-state-for-tea.patch \
        file://0069-netfilter-nf_flow_table-in-flow_offload_lookup-skip-.patch \
        file://0070-netfilter-nf_flow_table-add-support-for-sending-flow.patch \
        file://0071-netfilter-nf_flow_table-tear-down-TCP-flows-if-RST-o.patch \
        file://0072-netfilter-nf_flow_table-fix-checksum-when-handling-D.patch \
        file://0073-netfilter-nf_flow_table-clean-up-and-fix-dst-handlin.patch \
        file://0074-netfilter-nf_flow_table-add-missing-condition-for-TC.patch \
        file://0075-netfilter-nf_flow_table-fix-offloading-connections-w.patch \
        file://0076-netfilter-nf_flow_table-attach-dst-to-skbs.patch \
        file://0077-netfilter-nf_flow_table-fix-offloaded-connection-tim.patch \
        file://0078-net-phy-add-phy_ethtool_ioctl.patch \
        file://0079-netfilter-add-support-for-flushing-conntrack-via-pro.patch \
        file://0080-kernel-add-a-new-version-of-my-netfilter-speedup-pat.patch \
        file://0081-netfilter-match-bypass-default-table.patch \
        file://0082-netfilter-reduce-match-memory-access.patch \
        file://0083-netfilter-optional-tcp-window-check.patch \
        file://0084-netfilter-nf_flow_table-add-hardware-offload-support.patch \
        file://0085-netfilter-nf_flow_table-support-hw-offload-through-v.patch \
        file://0086-netfilter-nf_flow_table-rework-hardware-offload-time.patch \
        file://0087-netfilter-nf_flow_table-rework-private-driver-data.patch \
        file://0088-net-swconfig-adds-openwrt-switch-layer.patch \
        file://0089-Add-ethernet-and-esw-to-DTS.patch \
        file://0090-Enable-watchdog-in-DTS.patch \
        "

# KERNEL_FEATURES_append_mt7688 = ""
