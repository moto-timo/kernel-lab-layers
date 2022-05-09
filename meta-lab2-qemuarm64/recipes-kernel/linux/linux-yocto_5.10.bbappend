FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "lab2-qemuarm64"

KBRANCH:lab2-qemuarm64 = "v5.10/standard/base"
KMACHINE:lab2-qemuarm64  = "qemuarm64"

KERNEL_FEATURES:append:lab2-qemuarm64 = " cfg/smp.scc"

#SRC_URI += "file://mtd-block.cfg"

#SRC_URI += "file://yocto-testmod.patch"
#SRC_URI += "file://lab2.cfg"
