FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE:lab2-qemux86 = "lab2-qemux86"

KBRANCH:lab2-qemux86 = "v5.14/standard/base"
KMACHINE:lab2-qemux86  = "common-pc"

KERNEL_FEATURES:append:lab2-qemux86 = " cfg/smp.scc"

#SRC_URI += "file://yocto-testmod.patch"
#SRC_URI += "file://lab2.cfg"

SRCREV_machine:lab2-qemux86 ?= "c4def465fc44a7f5311d9b942d6cdd33cb4804ca"
