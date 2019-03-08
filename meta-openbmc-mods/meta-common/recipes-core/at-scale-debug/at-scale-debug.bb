inherit obmc-phosphor-systemd

SUMMARY = "At Scale Debug Service"
DESCRIPTION = "At Scale Debug Service exposes remote JTAG target debug capabilities"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40c94c59cbbc218afdd64eec899ad2f6"

inherit cmake
DEPENDS = "sdbusplus openssl libpam"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

SRC_URI = "git://git@github.com/Intel-BMC/at-scale-debug;protocol=ssh"

SRCREV = "de77d02aefa3c9df62365e7f07224c5cf9b0eb96"
S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} += "com.intel.AtScaleDebug.service"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DBUILD_UT=OFF"

CFLAGS_append = " -I ${STAGING_KERNEL_DIR}/include/"
