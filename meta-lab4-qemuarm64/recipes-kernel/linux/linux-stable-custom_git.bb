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

SRC_URI:lab4-qemuarm64 = "git://${HOME}/linux-stable-work.git;protocol=file;name=machine;branch=${KBRANCH}"
SRC_URI:lab4-qemuarm64 += "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.15;destsuffix=${KMETA}"
SRC_URI:lab4-qemuarm64 += "file://defconfig"

KBRANCH = "work-branch"
KMETA = "kernel-meta"

LINUX_VERSION:lab4-qemuarm64 ?= "5.15.37"
LINUX_VERSION_EXTENSION:lab4-qemuarm64 ?= "-custom"

SRCREV_machine:lab4-qemuarm64 = "${AUTOREV}"
SRCREV_meta:lab4-qemuarm64 = "b37a7198339ac27d27aec07ec5e952cc74c137f4"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"
#The following variable is for developers who need to use upstream kernels
# where the version number is in flux.
# Otherwise to stay on a specific kernel version explicity set LINUX_VERSION_lab4-qemuarm64
# to the full version number.  i.e; LINUX_VERSION_lab4-qemuarm64 ?= "5.15.2"
KERNEL_VERSION_SANITY_SKIP="1"

COMPATIBLE_MACHINE_lab4-qemuarm64 = "lab4-qemuarm64"
#The following features are metadata used by linux-yocto
KERNEL_FEATURES:remove:lab4-qemuarm64 = " features/debug/printk.scc "
KERNEL_FEATURES:remove:lab4-qemuarm64 = " features/kernel-sample/kernel-sample.scc"
KERNEL_FEATURES:remove:lab4-qemuarm64 = "cfg/fs/vfat.scc"
