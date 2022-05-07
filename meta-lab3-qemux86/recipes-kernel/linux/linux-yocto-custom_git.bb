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

# KBRANCH is the branch the used for the git clone. In this case the tip of 5.10 stable
KBRANCH = "linux-5.10.y"

SRC_URI_lab3-qemux86 = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;nocheckout=1;branch=${KBRANCH}"
SRC_URI_lab3-qemux86 += "file://defconfig"

LINUX_VERSION_lab3-qemux86 ?= "5.10.113"

# the sha of the commit for LINUX_VERSION.  git log --grep=<version> -n 1
SRCREV_lab3-qemux86="54af9dd2b958096a25860b80d48a04cf59b53475"

LINUX_VERSION_EXTENSION_lab3-qemux86 ?= "-custom"

#SRC_URI_lab3-qemux86 += "file://yocto-testmod.patch"
#SRC_URI_lab3-qemux86 += "file://lab3.cfg"

#KERNEL_MODULE_AUTOLOAD += "yocto-testmod"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_lab3-qemux86 = "lab3-qemux86"

#The following features are metadata used by linux-yocto
KERNEL_FEATURES:remove:lab3-qemux86 = " features/debug/printk.scc"
KERNEL_FEATURES:remove:lab3-qemux86 = " features/kernel-sample/kernel-sample.scc"
KERNEL_FEATURES:remove:lab3-qemux86 = "cfg/fs/vfat.scc"
