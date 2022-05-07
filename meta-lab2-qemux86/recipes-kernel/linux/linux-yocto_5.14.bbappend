FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE:lab2-qemux86 = "lab2-qemux86"

KBRANCH:lab2-qemux86 = "v5.14/standard/base"
KMACHINE:lab2-qemux86  = "common-pc"

KERNEL_FEATURES:append:lab2-qemux86 = " cfg/smp.scc"

#SRC_URI += "file://yocto-testmod.patch"
#SRC_URI += "file://lab2.cfg"

SRCREV_machine:lab2-qemux86 ?= "9d5572038eacda2e2a86e3f743f35ec415319fb4"
