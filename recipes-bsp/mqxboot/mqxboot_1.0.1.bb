# Copyright (C) 2013 Timesys Corporation
SUMMARY = "MQX Image loader - starts an MQX image on the M4"
LICENSE = "GPL-2.0-only | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49712341497d0b5f2e40c30dff2af9d \
                    file://BSD_LICENSE;md5=10695b8f86532e5e44640acf4d92a2ef"

DEPENDS = "virtual/kernel-module-mcc"

SRC_URI = " \
    http://repository.timesys.com/buildsources/m/mqxboot/mqxboot-${PV}/mqxboot-${PV}.tar.bz2 \
    file://0001-Makefile-use-OE-ldflags.patch \
"

SRC_URI[sha256sum] = "32444409de5e809b9347e275a3bf78623a89e9ecce3188ebac79318b2b7c39b3"

S = "${WORKDIR}/mqxboot-${PV}"

CFLAGS += "-I${STAGING_KERNEL_DIR}/include"

RDEPENDS:${PN} = "virtual/kernel-module-mcc"

COMPATIBLE_MACHINE = "(vf-generic-bsp)"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}
