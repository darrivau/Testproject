cmake_minimum_required (VERSION 2.6) 
project (IMMCOMPLX_JAVA_TEST Java) 

set(JUNIT_JAR ${IMMCOMPLX_JAVA_DEPENDENCIES_DIR}/junit-${JUNIT_VERSION}.jar)
set(HAMCREST_JAR ${IMMCOMPLX_JAVA_DEPENDENCIES_DIR}/hamcrest-all-${HAMCREST_VERSION}.jar)

# Compile of the test file
add_jar(immutablecomplex-test java/ComplexTest.java INCLUDE_JARS ${JUNIT_JAR} ${IMMCOMPLX_JAR})
# Get the jar location
get_target_property(IMMCOMPLX_TEST_JAR immutablecomplex-test JAR_FILE)

# Adding test case for ctest
set(CLASSPATH "${JUNIT_JAR}:${HAMCREST_JAR}:${IMMCOMPLX_JAR}:${IMMCOMPLX_TEST_JAR}")
add_test(
NAME test_immutablecomplex
COMMAND ${Java_JAVA_EXECUTABLE} -cp ${CLASSPATH} org.junit.runner.JUnitCore test.java.ComplexTest
)
