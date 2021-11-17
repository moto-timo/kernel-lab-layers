FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "lab2-qemux86"

KBRANCH_lab2-qemux86 = "v5.4/standard/base"
KMACHINE_lab2-qemux86  = "common-pc"

KERNEL_FEATURES_append_lab2-qemux86 += " cfg/smp.scc"

#SRC_URI += "file://mtd-block.cfg"

SRC_URI += "file://yocto-testmod.patch"
SRC_URI += "file://lab2.cfg"
