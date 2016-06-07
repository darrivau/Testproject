cmake_minimum_required (VERSION 2.8) 
project (IMMCOMPLX_JAVA Java)

set(IMMCOMPLX_VERSION "1.0.0")

# Setting source jar install path as a cmake cache variable
# Using default cmake install path if not defined (/usr/lib)
set(JAR_INSTALL_DIR ${CMAKE_INSTALL_PREFIX} CACHE PATH "Path to source jar installation directory")
# Setting lib directory
set(IMMCOMPLX_JAVA_DEPENDENCIES_DIR ${IMMCOMPLX_JAVA_SOURCE_DIR}/lib)

include(FindJava)
include(UseJava)

set(JUNIT_VERSION "4.11")
set(HAMCREST_VERSION "1.3")

enable_testing()

add_subdirectory(src/main)
add_subdirectory(src/test)

