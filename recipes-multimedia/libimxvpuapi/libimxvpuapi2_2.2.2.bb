DESCRIPTION = "frontend for the i.MX6 / i.MX8 VPU hardware video engines"
HOMEPAGE = "https://github.com/Freescale/libimxvpuapi"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38fa42a5a6425b26d2919b17b1527324"
SECTION = "multimedia"
DEPENDS = "virtual/imxvpu libimxdmabuffer"

PV .= "+git${SRCPV}"

SRCBRANCH ?= "master"
SRCREV = "b6486118d47937cd717c4881158dda6e72cf2855"
SRC_URI = "git://github.com/Freescale/libimxvpuapi.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit waf pkgconfig use-imx-headers

IMX_PLATFORM:mx6-nxp-bsp = "imx6"
IMX_PLATFORM:mx8mq-nxp-bsp = "imx8m"
IMX_PLATFORM:mx8mm-nxp-bsp = "imx8mm"
IMX_PLATFORM:mx8mp-nxp-bsp = "imx8m"

EXTRA_OECONF = "--imx-platform=${IMX_PLATFORM} --libdir=${libdir} --imx-headers=${STAGING_INCDIR_IMX} --sysroot-path=${RECIPE_SYSROOT}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(imxvpu)"
