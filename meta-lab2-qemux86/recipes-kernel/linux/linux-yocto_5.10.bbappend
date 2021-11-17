FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "lab2-qemux86"

KBRANCH:lab2-qemux86 = "v5.10/standard/base"
KMACHINE:lab2-qemux86  = "common-pc"

KERNEL_FEATURES:append:lab2-qemux86 = " cfg/smp.scc"

#SRC_URI += "file://mtd-block.cfg"

#SRC_URI += "file://yocto-testmod.patch"
#SRC_URI += "file://lab2.cfg"
