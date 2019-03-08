SUMMARY = "Gpio daemon service for handling gpio operations"
DESCRIPTION = "Daemon allows to block gpio access under certain conditions"

PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git/gpiodaemon"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI = "git://git@github.com/Intel-BMC/provingground.git;protocol=ssh"

SRCREV = "3cc86d6c536b4c5ee7afb5447837b83ce8b3d149"

inherit cmake systemd
SYSTEMD_SERVICE_${PN} = "gpiodaemon.service"

DEPENDS = "boost systemd sdbusplus phosphor-logging"
