FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_lab2-qemux86 = "lab2-qemux86"

KBRANCH_lab2-qemux86 = "v5.10/standard/base"
KMACHINE_lab2-qemux86  = "common-pc"

KERNEL_FEATURES:append:lab2-qemux86 += " cfg/smp.scc"

#SRC_URI = "git:///home/jay/poky/linux-yocto-5.10.git;name=machine;branch=${KBRANCH}; \
#           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=${KMETA}"
#KERNEL_VERSION_SANITY_SKIP="1"

#SRC_URI += "file://yocto-testmod.patch"
#SRC_URI += "file://lab2.cfg"

#SRCREV_machine:pn-linux-yocto:lab2-qemux86 ?= "${AUTOREV}"
#SRCREV_meta:linux-yocto:lab2-qemux86 ?= "${AUTOREV}"
