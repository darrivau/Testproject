cmake_minimum_required (VERSION 2.8) 
project (IMMCOMPLX_JAVA_MAIN Java) 

set(CMAKE_JAVA_TARGET_OUTPUT_NAME immutablecomplex)

# Compile the source files into a jar with a main
add_jar(immutablecomplex java/Complex.java java/Main.java 
ENTRY_POINT main/java/Main
VERSION ${IMMCOMPLX_VERSION})

# Get the jar location
get_target_property(JAR immutablecomplex JAR_FILE)
# Set it to parent scope
set(IMMCOMPLX_JAR ${JAR} PARENT_SCOPE)

# Install the jar
message(STATUS "JAR_INSTALL_DIR = ${JAR_INSTALL_DIR}")
install_jar(immutablecomplex ${JAR_INSTALL_DIR})

# Create the javadoc
create_javadoc(immutablecomplex_doc
FILES java/Complex.java
CLASSPATH ${CMAKE_JAVA_INCLUDE_PATH}
WINDOWTITLE "My Complex Numbers"
DOCTITLE "<h1>My Complex Numbers</h1>"
INSTALLPATH ${JAR_INSTALL_DIR}
AUTHOR TRUE
USE TRUE
VERSION TRUE
)
