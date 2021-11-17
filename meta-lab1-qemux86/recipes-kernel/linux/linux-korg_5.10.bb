DESCRIPTION = "Mainline Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel


SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v5.x/linux-${PV}.tar.gz;name=kernel \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

#SRC_URI += "file://yocto-testmod.patch"

SRC_URI[kernel.sha256sum] = "91169da4618d182599963926cad0256bcf6f5c74bac47b24c199374539323e64"


