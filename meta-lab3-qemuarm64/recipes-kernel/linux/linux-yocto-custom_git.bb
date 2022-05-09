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
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# KBRANCH is the branch the used for the git clone. In this case the tip of 5.17 stable
KBRANCH = "linux-5.17.y"

SRC_URI:lab3-qemuarm64 = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=${KBRANCH}"
SRC_URI:lab3-qemuarm64 += "file://defconfig"

LINUX_VERSION:lab3-qemuarm64 ?= "5.17.5"

# the sha of the commit for 5.17.5.  git rev-list -n 1 v5.17.5
SRCREV:lab3-qemuarm64="2731bd17017d4a0e2180a1917ab22d7820a07330"

LINUX_VERSION_EXTENSION:lab3-qemuarm64 ?= "-custom"

#SRC_URI:lab3-qemuarm64 += "file://yocto-testmod.patch"
#SRC_URI:lab3-qemuarm64 += "file://lab3.cfg"

#KERNEL_MODULE_AUTOLOAD += "yocto-testmod"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE:lab3-qemuarm64 = "lab3-qemuarm64"

#The following features are metadata used by linux-yocto
KERNEL_FEATURES:remove:lab3-qemuarm64 = " features/debug/printk.scc"
KERNEL_FEATURES:remove:lab3-qemuarm64 = " features/kernel-sample/kernel-sample.scc"
KERNEL_FEATURES:remove:lab3-qemuarm64 = "cfg/fs/vfat.scc"
