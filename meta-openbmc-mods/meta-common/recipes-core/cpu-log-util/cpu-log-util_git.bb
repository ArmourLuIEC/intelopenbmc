inherit obmc-phosphor-dbus-service
inherit obmc-phosphor-systemd

SUMMARY = "CPU Log Utils"
DESCRIPTION = "CPU utilities for dumping CPU registers over PECI"

DEPENDS = "boost cjson sdbusplus "
inherit cmake

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@github.com/Intel-BMC/at-scale-debug;protocol=ssh"
SRCREV = "de77d02aefa3c9df62365e7f07224c5cf9b0eb96"

S = "${WORKDIR}/git/cpu-log-util"
PACKAGES += "libpeci"

SYSTEMD_SERVICE_${PN} += "com.intel.CpuDebugLog.service"
DBUS_SERVICE_${PN} += "com.intel.CpuDebugLog.service"

# linux-libc-headers guides this way to include custom uapi headers
CFLAGS_append = " -I ${STAGING_KERNEL_DIR}/include/uapi"
CFLAGS_append = " -I ${STAGING_KERNEL_DIR}/include"
CXXFLAGS_append = " -I ${STAGING_KERNEL_DIR}/include/uapi"
CXXFLAGS_append = " -I ${STAGING_KERNEL_DIR}/include"
do_configure[depends] += "virtual/kernel:do_shared_workdir"
