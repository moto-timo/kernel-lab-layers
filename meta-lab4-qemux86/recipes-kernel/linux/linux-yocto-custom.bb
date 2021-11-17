# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI_lab4-qemux86 = "git:///home/jay/poky/linux-stable-work.git"
SRC_URI_lab4-qemux86 += "file://defconfig"

KBRANCH = "work-branch"

LINUX_VERSION_lab4-qemux86 ?= "5.10.66"
LINUX_VERSION_EXTENSION_lab4-qemux86 ?= "-custom"

SRCREV_lab4-qemux86="${AUTOREV}"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"
#The following variable is for developers who need to use upstream kernels
# where the version number is in flux.
# Otherwise to stay on a specific kernel version explicity set LINUX_VERSION_lab4-qemux86
# to the full version number.  i.e; LINUX_VERSION_lab4-qemux86 ?= "4.18.20"
KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE_lab4-qemux86 = "lab4-qemux86"
#The following features are metadata used by linux-yocto
KERNEL_FEATURES:remove:lab4-qemux86 = " features/debug/printk.scc "
KERNEL_FEATURES:remove:lab4-qemux86 = " features/kernel-sample/kernel-sample.scc"
KERNEL_FEATURES:remove:lab3-qemux86 = "cfg/fs/vfat.scc"
