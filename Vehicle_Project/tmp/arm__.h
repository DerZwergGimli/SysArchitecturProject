#include <stdlib.h>
#include <stdio.h>
#include "jamaica.h"
#include "jni.h"
#include "jbi.h"


#ifdef __JAMAICA__

#ifdef __cplusplus
extern "C" {
#endif

#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_CpuTime_nativeGetCpuRate(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Debug_native_1print__Ljava_lang_String_2(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Debug_native_1println(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeDumpStackOf(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetExecutionTime(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetTotalExecutionTime(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetGarbageCollectionTime(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetInterpreterTime(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetThreadPoolSize(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeFillMethodList(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetMember(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetVMThreadId(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetSystemThreadId(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_Debug_nativeGetThread(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_MemoryReservationThread_reservedMemoryPercentage(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_MemoryReservationThread_reservedMemory(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_MemoryReservationThread_minReservedMemory(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_MemoryReservationThread_performReservation(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_MemoryReservationThread_registerPriority(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_ModuleLoader_registerLoadedClass(jamaica_thread *currentThread, jamaica_int64 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_com_aicas_jamaica_lang_ModuleLoader_load(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_ModuleLoader_unload(jamaica_thread *currentThread, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_dumpProfileData(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_dumpProfileDataViaNet(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_resetProfileData(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_profileMemory(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_profileSpeed(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_dumpProfileAtTerminationOfVM(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_forceDumpAtTerminationOfVM(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Profile_setQuietDump(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_Scheduler_recordTo0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Scheduler_recordUserEvent0(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Scheduler_useStrictPriority0(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_Scheduler_microAdjustPriority0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_lang_Scheduler_setLeastEligible0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_VMInterface_isDebug(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_VMInterface_isProfile(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_VMInterface_isMulticore(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_VMInterface_hasJVMTI(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_lang_VMInterface_getTarget(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_lang_VMInterface_getMajorVersion(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_AllocationScopeStack_getDepth(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_AllocationScopeStack_reset(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_realtime_AllocationScopeStack_getOuter0(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_realtime_AllocationScopeStack_pop0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_realtime_AllocationScopeStack_push0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_blockSize(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_getMemoryArea0(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_setIsNoHeapThread(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_strictRTSJ(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_wait0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_throwPendingAsynchronouslyInterruptedException(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_obj2int(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_com_aicas_jamaica_realtime_LowLevelRTSJ_int2obj(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_java_net_protocol_rom_ROMInputStream_nativeInit(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_java_net_protocol_rom_ROMInputStream_nativeReadOneByte(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_java_net_protocol_rom_ROMInputStream_nativeRead(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_com_aicas_java_net_protocol_rom_ROMInputStream_nativeAvailable(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getModifiers0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_compatibleClass(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getName0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getName1(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getGenericSignature0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getSuperclass(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_numInterfaces(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getInterface(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getInnerClassInfoEntryCount(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getInnerClassInfoInnerClass(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getInnerClassInfoOuterClass(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getEnclosingMethod0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getNextRoutine(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getNextField(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getFeatureName(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getGenericFeatureDescriptor(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getFeatureDescriptor(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getFeatureExceptionTypes(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getFeatureAccessFlags(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getFieldSlot(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getMethodSlot(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getMethodAnnotations(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getFieldAnnotations(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getMethodParameterAnnotations(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getMethodAnnotationDefault(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_getTypeId(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_inError(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Class_nativeThrowException(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getRawAnnotations(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getRawTypeAnnotations(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getPrimitiveClass(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Class_verify(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_forName0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_isAssignableFrom(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getDeclaringClass0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Class_desiredAssertionStatus0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Class_getCpoolData(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_getNewPSArray(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_ClassLoader_load(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_ClassLoader_unload(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_ClassLoader_getLibrarySymbolAddress0(jamaica_thread *currentThread, jamaica_int64 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_ClassLoader_freeCallDataList(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_defineClass0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_ClassLoader_resolveClass0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_findBootClass0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_findLoadedClass0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_getLoadedClassesFromLoader(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ClassLoader_retrieveDirectives(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_Double_doubleToRawLongBits(jamaica_thread *currentThread, jamaica_double arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_double JBICALL Jam_java_lang_Double_longBitsToDouble(jamaica_thread *currentThread, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Float_floatToRawIntBits(jamaica_thread *currentThread, jamaica_float arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_float JBICALL Jam_java_lang_Float_intBitsToFloat(jamaica_thread *currentThread, jamaica_int32 arg0);
extern jamaica_ref jam_class_java_lang_Object_112;
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Object_getClass(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Object_clone(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Object_notify(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Object_notifyAll(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Object_wait(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_Runtime_freeMemory(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_Runtime_totalMemory(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_Runtime_maxMemory(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Runtime_gc(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Runtime_runFinalization0(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Runtime_JNIOnLoad0(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Shutdown_halt0(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Shutdown_runAllFinalizers(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_String_allocString(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_String_setCharacter(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_String_copyChars(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_String_cast2string(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_String_makeImmortal0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_String_findInternedSystemString(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_String_charAt(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_String_equals(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_String_compareTo(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_String_hashCode(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_String_indexOf(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_System_setStatic(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_System_nativeGetFixedSystemProperties(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_System_nativeGetSystemProperties(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_System_nativeGetUserDefinedProperties(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_System_identityHashCode(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_System_nativeCurrentTimeMillis(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_System_set_1oom(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_System_setSoftRefMinFree(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_System_useDebugInterface(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_System_arraycopy(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_System_nativeNanoTime(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_getNumberOfThreads(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_getMaxNumberOfThreads(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Thread_nativeGetThreadAt(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_start0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_interrupted0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_setPriority0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_getMaxPriority(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_nativeHoldsLock(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_countStackFrames0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Thread_nativeFillInStackTraceFor(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Thread_currentThread(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_yield(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Thread_getState0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_suspend0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_resume0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_interrupt0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_Thread_setNativeName(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Throwable_fillInStackTrace(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_Throwable_getStackTraceDepth(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_Throwable_getStackTraceElement(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_invoke_MethodHandleNatives_init(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_invoke_MethodHandleNatives_expand(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_invoke_MethodHandleNatives_resolve(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_invoke_MethodHandleNatives_getMembers(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_invoke_MethodHandleNatives_objectFieldOffset(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_java_lang_invoke_MethodHandleNatives_staticFieldOffset(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_invoke_MethodHandleNatives_staticFieldBase(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_invoke_MethodHandleNatives_setCallSiteTargetNormal(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_invoke_MethodHandleNatives_setCallSiteTargetVolatile(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_invoke_MethodHandleNatives_registerNatives(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_invoke_MethodHandleNatives_getNamedCon(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ref_Reference_pending(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_ref_Reference_activate(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_ref_Reference_get(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_lang_reflect_Array_getLength(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_reflect_Array_get(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_java_lang_reflect_Array_set(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_reflect_Array_newArray(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_reflect_Executable_getParameters0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_java_lang_reflect_Executable_getTypeAnnotationBytes0(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_java_util_concurrent_atomic_AtomicLong_VMSupportsCS8(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_Affinity_getSystemCpuId(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_Affinity_getPredefinedCpuSet(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_Affinity_setAffinityNative(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_javax_realtime_MemoryArea_getMemoryAreaFromIndex(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_arrayElementsInHeaderInBytes(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_arrayWidthInBytes(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_sizeOfReferenceInBytes(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_javax_realtime_MemoryArea_sizeOfImmortalMemory(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_numBlocks(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_javax_realtime_MemoryArea_getMA(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_MemoryArea_setMemoryBudgets(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_getAllocatedMemory(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_MemoryArea_setPendingAIE(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_javax_realtime_MemoryArea_getPendingAIE(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_checkAccess(jamaica_thread *currentThread, jamaica_int64 arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_getMonitorControl(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_MemoryArea_setMonitorControl(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_MemoryArea_setDefaultMonitorCeilingPri(jamaica_thread *currentThread, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_javax_realtime_MemoryArea_makeImmortal0(jamaica_thread *currentThread, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_PriorityScheduler_getMaxPriority(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_PriorityScheduler_checkPriority(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_RealtimeClock_getSystemTime0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_javax_realtime_RealtimeClock_realtimeClockId(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_javax_realtime_memory_ScopedMemory_clear(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_JamaicaRomUrlClassLoader_loadClassFromROM0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_JamaicaRomUrlClassLoader_builtinClassPath(jamaica_thread *currentThread, jamaica_int32 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Perf_createLong(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Perf_registerNatives(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_registerNatives(jamaica_thread *currentThread);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getInt__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putInt__Ljava_lang_Object_2JI(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_getObject(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putObject(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getBoolean(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putBoolean(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getByte__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putByte__Ljava_lang_Object_2JB(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getShort__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putShort__Ljava_lang_Object_2JS(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getChar__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putChar__Ljava_lang_Object_2JC(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_getLong__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putLong__Ljava_lang_Object_2JJ(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_float JBICALL Jam_sun_misc_Unsafe_getFloat__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putFloat__Ljava_lang_Object_2JF(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_float arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_double JBICALL Jam_sun_misc_Unsafe_getDouble__Ljava_lang_Object_2J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putDouble__Ljava_lang_Object_2JD(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_double arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getByte__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putByte__JB(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getShort__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putShort__JS(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getChar__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putChar__JC(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getInt__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putInt__JI(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_getLong__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putLong__JJ(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_float JBICALL Jam_sun_misc_Unsafe_getFloat__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putFloat__JF(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_float arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_double JBICALL Jam_sun_misc_Unsafe_getDouble__J(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putDouble__JD(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_double arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_getAddress(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putAddress(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_allocateMemory(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_reallocateMemory(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_setMemory(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_copyMemory(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_int64 arg4);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_freeMemory(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int64 arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_staticFieldOffset(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_objectFieldOffset(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_staticFieldBase(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_shouldBeInitialized(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_ensureClassInitialized(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_arrayBaseOffset(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_arrayIndexScale(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_addressSize(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_pageSize(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_defineClass(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_defineAnonymousClass(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_allocateInstance(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_monitorEnter(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_monitorExit(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_tryMonitorEnter(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_throwException(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_compareAndSwapObject(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_ref arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_compareAndSwapInt(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_compareAndSwapLong(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_misc_Unsafe_getObjectVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putObjectVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getIntVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putIntVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getBooleanVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putBooleanVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getByteVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putByteVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getShortVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putShortVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getCharVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putCharVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_misc_Unsafe_getLongVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putLongVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_float JBICALL Jam_sun_misc_Unsafe_getFloatVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putFloatVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_float arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_double JBICALL Jam_sun_misc_Unsafe_getDoubleVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putDoubleVolatile(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_double arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putOrderedObject(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putOrderedInt(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_putOrderedLong(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_unpark(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_park(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_int32 arg0, jamaica_int64 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_misc_Unsafe_getLoadAverage(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_loadFence(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_storeFence(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT void JBICALL Jam_sun_misc_Unsafe_fullFence(jamaica_thread *currentThread, jamaica_ref thiz);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_reflect_ConstantPool_getSize0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getClassAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getClassAtIfLoaded0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getMethodAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getMethodAtIfLoaded0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getFieldAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getFieldAtIfLoaded0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getMemberRefInfoAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int32 JBICALL Jam_sun_reflect_ConstantPool_getIntAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_int64 JBICALL Jam_sun_reflect_ConstantPool_getLongAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_float JBICALL Jam_sun_reflect_ConstantPool_getFloatAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_double JBICALL Jam_sun_reflect_ConstantPool_getDoubleAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getStringAt0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_ConstantPool_getUTF8At0(jamaica_thread *currentThread, jamaica_ref thiz, jamaica_ref arg0, jamaica_int32 arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_NativeConstructorAccessorImpl_newInstance0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1);
#ifdef __cplusplus
  extern "C"
#endif
JBIEXPORT jamaica_ref JBICALL Jam_sun_reflect_NativeMethodAccessorImpl_invoke0(jamaica_thread *currentThread, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RR(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RI(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT void JBICALL REV_STUB_RRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RV(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT void JBICALL REV_STUB_IV(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT void JBICALL REV_STUB_RRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RIRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_III(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT void JBICALL REV_STUB_IIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_R(jamaica_thread *ct);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_IIRV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_V(jamaica_thread *ct);
JBIEXPORT void JBICALL REV_STUB_RIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_I(jamaica_thread *ct);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_J(jamaica_thread *ct);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJ(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT void JBICALL REV_STUB_JRV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_II(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT void JBICALL REV_STUB_JV(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IR(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT void JBICALL REV_STUB_RJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_IRV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT void JBICALL REV_STUB_RJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JJ(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IJ(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JI(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRIIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_JIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_float JBICALL REV_STUB_RIF(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_RID(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RIFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_float arg2);
JBIEXPORT void JBICALL REV_STUB_RIJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RIDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_float JBICALL REV_STUB_RF(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT jamaica_double JBICALL REV_STUB_RD(jamaica_thread *ct, jamaica_ref arg0);
JBIEXPORT void JBICALL REV_STUB_RFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_float arg1);
JBIEXPORT void JBICALL REV_STUB_RDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1);
JBIEXPORT void JBICALL REV_STUB_RJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT void JBICALL REV_STUB_RRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRJJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_RRDD(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RIIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RFR(jamaica_thread *ct, jamaica_ref arg0, jamaica_float arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_IRIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JRJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RIRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_DR(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_DI(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_DJ(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT jamaica_double JBICALL REV_STUB_JD(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_DDI(jamaica_thread *ct, jamaica_double arg0, jamaica_double arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_DDD(jamaica_thread *ct, jamaica_double arg0, jamaica_double arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_FR(jamaica_thread *ct, jamaica_float arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_FI(jamaica_thread *ct, jamaica_float arg0);
JBIEXPORT jamaica_float JBICALL REV_STUB_IF(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_FFI(jamaica_thread *ct, jamaica_float arg0, jamaica_float arg1);
JBIEXPORT jamaica_float JBICALL REV_STUB_FFF(jamaica_thread *ct, jamaica_float arg0, jamaica_float arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IIRIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JR(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIRIII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_JIRV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JJI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JJJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JIJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_DD(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT jamaica_double JBICALL REV_STUB_D(jamaica_thread *ct);
JBIEXPORT jamaica_float JBICALL REV_STUB_FF(jamaica_thread *ct, jamaica_float arg0);
JBIEXPORT jamaica_float JBICALL REV_STUB_FDF(jamaica_thread *ct, jamaica_float arg0, jamaica_double arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_DID(jamaica_thread *ct, jamaica_double arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_float JBICALL REV_STUB_FIF(jamaica_thread *ct, jamaica_float arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_ID(jamaica_thread *ct, jamaica_int32 arg0);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_double JBICALL REV_STUB_DDDDD(jamaica_thread *ct, jamaica_double arg0, jamaica_double arg1, jamaica_double arg2, jamaica_double arg3);
JBIEXPORT void JBICALL REV_STUB_RRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IFI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_float arg1);
JBIEXPORT void JBICALL REV_STUB_RIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRRJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRRJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRRRIRIRRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_int32 arg10);
JBIEXPORT void JBICALL REV_STUB_RRRIRIRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIFR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_float arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_double arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRFR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_float arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_double arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RRRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRRJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int64 arg5);
JBIEXPORT void JBICALL REV_STUB_RRRRRJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int64 arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RRIRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_float JBICALL REV_STUB_F(jamaica_thread *ct);
JBIEXPORT void JBICALL REV_STUB_RIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRRRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIFR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_float arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_double arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IIJ(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IIIJ(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IIIIJ(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RJRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10, jamaica_ref arg11);
JBIEXPORT void JBICALL REV_STUB_RRRRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRRRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRIRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RRRRRIRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10);
JBIEXPORT void JBICALL REV_STUB_RRRRIIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRRRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRRRRRIIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10, jamaica_ref arg11);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRIIRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_ref arg10, jamaica_ref arg11);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRJIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RDRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJIIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JJIJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IIIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIIJJI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIIRJI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIJR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIJIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIRIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIJIJRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIJIJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIRIJRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJJIIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJJIIIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIIIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JJJJJJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIJII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIRII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JRIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJIRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JRIRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJIIRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JJJJI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIJIIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIJIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JIRIIIR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JRR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
JBIEXPORT void JBICALL REV_STUB_RIIRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRIIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRIIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RRRIIRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRRJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRRIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRRRRRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IJJI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIJJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RIIJJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIJJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRRIRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRIRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRRIRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_JIIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IIIIIIIIJ(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_JJV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1);
JBIEXPORT void JBICALL REV_STUB_RIJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_JJIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_float JBICALL REV_STUB_JF(jamaica_thread *ct, jamaica_int64 arg0);
JBIEXPORT jamaica_float JBICALL REV_STUB_RIIF(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_float JBICALL REV_STUB_JIF(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_JFV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_float arg1);
JBIEXPORT void JBICALL REV_STUB_RIFIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_float arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_JFIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_float arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_RIID(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_JID(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_JDV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_double arg1);
JBIEXPORT void JBICALL REV_STUB_RIDIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_double arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_JDIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_double arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RJJJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_JRJJJV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RJJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT void JBICALL REV_STUB_JRJJV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT void JBICALL REV_STUB_RIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_IIIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RIIIIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RRIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RJIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RIJRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_float JBICALL REV_STUB_RJF(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJFR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_float arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_RJD(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RJJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RJJIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRIIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJJRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRJJJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJJIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RRJJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RRFFRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_float arg2, jamaica_float arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRFFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_float arg2, jamaica_float arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JJJJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRDRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_double arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIRRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RDRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIIRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RDII(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RDIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIIIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRRRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RIDIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_double arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RIRIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RIIRRRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RIIRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIIIRRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int32 arg8, jamaica_ref arg9);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJJJJIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int64 arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_IRRV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJJJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RRRJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJJJJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int64 arg5);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIIIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRRRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRJRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRIRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJJR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_JJJJR(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRIRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRIRRIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RRIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RDI(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIDI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_double arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RFI(jamaica_thread *ct, jamaica_ref arg0, jamaica_float arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIFI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_float arg3);
JBIEXPORT void JBICALL REV_STUB_RIIJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3);
JBIEXPORT void JBICALL REV_STUB_RIIDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_double arg3);
JBIEXPORT void JBICALL REV_STUB_RIIFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_float arg3);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_int32 arg9);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_int32 arg9, jamaica_ref arg10);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RRIJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_IIIIIIJ(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RFRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_float arg1, jamaica_ref arg2);
JBIEXPORT void JBICALL REV_STUB_RRDRRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_double arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RDIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RRRRRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJJJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_RDDD(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_double arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJJJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJDDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_double arg2, jamaica_double arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RDDR(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RRJJDDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_double arg4, jamaica_double arg5);
JBIEXPORT void JBICALL REV_STUB_RRJJIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRJJJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int64 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRRRJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int64 arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIRIIIIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_int32 arg9, jamaica_int32 arg10, jamaica_int32 arg11);
JBIEXPORT void JBICALL REV_STUB_RIRIIIIIIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_int32 arg9, jamaica_int32 arg10, jamaica_int32 arg11, jamaica_int32 arg12, jamaica_int32 arg13);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRIJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRRIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRRIIIIIIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RRJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RIIRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIIIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRRRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_double JBICALL REV_STUB_RJRDRD(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_double arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJRJRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRIIIJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int64 arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRIIIJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int64 arg5);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRDRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_double arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int32 arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int64 arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJRJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int64 arg3);
JBIEXPORT void JBICALL REV_STUB_RIRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RJJDDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_double arg3, jamaica_double arg4);
JBIEXPORT void JBICALL REV_STUB_RJJIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RIIJRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RIIJRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RDJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_RDD(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1);
JBIEXPORT jamaica_double JBICALL REV_STUB_RRRD(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2);
JBIEXPORT jamaica_double JBICALL REV_STUB_RRD(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIRIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRIRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RRIIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_double JBICALL REV_STUB_RDRD(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJJRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRJJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_DRR(jamaica_thread *ct, jamaica_double arg0, jamaica_ref arg1);
JBIEXPORT void JBICALL REV_STUB_RRRDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_double arg3);
JBIEXPORT void JBICALL REV_STUB_RRRIJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_int64 arg5);
JBIEXPORT void JBICALL REV_STUB_RRRRRJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int64 arg5, jamaica_int64 arg6);
JBIEXPORT void JBICALL REV_STUB_DV(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT void JBICALL REV_STUB_RRJJJJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int64 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IJIII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_JRIIV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JRIJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIJIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JJJRIII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRIIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RIIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RIIIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RJIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRRRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRRRRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_RRIRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRRIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIRIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRRRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIIRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRRRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_RRIRRRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT jamaica_float JBICALL REV_STUB_DF(jamaica_thread *ct, jamaica_double arg0);
JBIEXPORT jamaica_double JBICALL REV_STUB_FD(jamaica_thread *ct, jamaica_float arg0);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_FJ(jamaica_thread *ct, jamaica_float arg0);
JBIEXPORT void JBICALL REV_STUB_RRIRRIRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RRIRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RJRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RIRIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RIRIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_DRV(jamaica_thread *ct, jamaica_double arg0, jamaica_ref arg1);
JBIEXPORT void JBICALL REV_STUB_FRV(jamaica_thread *ct, jamaica_float arg0, jamaica_ref arg1);
JBIEXPORT jamaica_ref JBICALL REV_STUB_DIR(jamaica_thread *ct, jamaica_double arg0, jamaica_int32 arg1);
JBIEXPORT void JBICALL REV_STUB_RIJIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_RDFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_double arg1, jamaica_float arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_DIRR(jamaica_thread *ct, jamaica_double arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIJR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int64 arg4);
JBIEXPORT void JBICALL REV_STUB_RRJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_float JBICALL REV_STUB_RRJF(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRJFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_float arg3);
JBIEXPORT jamaica_double JBICALL REV_STUB_RRJD(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRJDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_double arg3);
JBIEXPORT jamaica_float JBICALL REV_STUB_RRIF(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RRIFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_float arg3);
JBIEXPORT jamaica_double JBICALL REV_STUB_RRID(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_RRIDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_double arg3);
JBIEXPORT void JBICALL REV_STUB_RJFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_float arg2);
JBIEXPORT void JBICALL REV_STUB_RJDV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_double arg2);
JBIEXPORT void JBICALL REV_STUB_RRJRJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_int64 arg4, jamaica_int64 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRIIRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJJJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RRRRRRJJV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int64 arg6, jamaica_int64 arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRIRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT void JBICALL REV_STUB_RRRJRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIRIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT void JBICALL REV_STUB_RIRRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6);
JBIEXPORT void JBICALL REV_STUB_RIRIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRRRRRRRRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRRRIRRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRJIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRJIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJIJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJIJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJIRRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RJIRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIJJJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRJJRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RJJIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIJJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int64 arg3, jamaica_int64 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJIJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_int64 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJIJI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_int32 arg2, jamaica_int64 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIJJII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_int64 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRJRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RRIIRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRRII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRRIRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IJRRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIRIIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JRI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_ref arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRJII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IJJII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_IRJIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_IJJIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_IJV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IJII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRRRIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT void JBICALL REV_STUB_IIJV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIII(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_IJIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int32 arg2);
JBIEXPORT void JBICALL REV_STUB_JIJV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_JJJV(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_IJJV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int64 arg1, jamaica_int64 arg2);
JBIEXPORT void JBICALL REV_STUB_RRJIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RIIRRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5);
JBIEXPORT jamaica_float JBICALL REV_STUB_RRF(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1);
JBIEXPORT void JBICALL REV_STUB_RRFV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_float arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRRRRRIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_ref arg9);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IRRRRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRIIRRRIIIIRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_int32 arg9, jamaica_int32 arg10, jamaica_ref arg11, jamaica_int32 arg12, jamaica_int32 arg13);
JBIEXPORT void JBICALL REV_STUB_RRIIRRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_int32 arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRIRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_IRIIV(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIRIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRIIRRIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RIIRRIIIRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRIIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT void JBICALL REV_STUB_RRRIIIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT void JBICALL REV_STUB_RRRRRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT void JBICALL REV_STUB_RRRRIIRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_int32 arg7, jamaica_int32 arg8, jamaica_ref arg9, jamaica_ref arg10);
JBIEXPORT void JBICALL REV_STUB_RRRIIRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IRIIRII(jamaica_thread *ct, jamaica_int32 arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIRRR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3);
JBIEXPORT void JBICALL REV_STUB_RRRIRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
JBIEXPORT void JBICALL REV_STUB_RRIRIIRRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_ref arg8, jamaica_ref arg9, jamaica_int32 arg10);
JBIEXPORT void JBICALL REV_STUB_RRRRIRIIRRV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6, jamaica_int32 arg7, jamaica_ref arg8, jamaica_ref arg9);
JBIEXPORT void JBICALL REV_STUB_RRIRRIIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_IIRRIR(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_ref arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IIRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRIIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIIRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRIRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_ref arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RRIIRIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_int32 arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_JIRI(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_ref arg2);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIIIIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRIIIRRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7, jamaica_ref arg8);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIIIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RIRIIIRR(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_ref arg6);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_IIJRRIIRIRI(jamaica_thread *ct, jamaica_int32 arg0, jamaica_int32 arg1, jamaica_int64 arg2, jamaica_ref arg3, jamaica_ref arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7, jamaica_int32 arg8, jamaica_ref arg9);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIIRIIIRI(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_ref arg3, jamaica_int32 arg4, jamaica_int32 arg5, jamaica_int32 arg6, jamaica_ref arg7);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_RIIIRJ(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4);
JBIEXPORT void JBICALL REV_STUB_RRRJIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_ref arg2, jamaica_int64 arg3, jamaica_int32 arg4);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRJIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int64 arg2, jamaica_int32 arg3);
JBIEXPORT void JBICALL REV_STUB_RRIIIRRRIV(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_ref arg6, jamaica_ref arg7, jamaica_int32 arg8);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RJRII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int64 arg1, jamaica_ref arg2, jamaica_int32 arg3);
JBIEXPORT jamaica_int32 JBICALL REV_STUB_RIRIJIII(jamaica_thread *ct, jamaica_ref arg0, jamaica_int32 arg1, jamaica_ref arg2, jamaica_int32 arg3, jamaica_int64 arg4, jamaica_int32 arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_int64 JBICALL REV_STUB_JIIJ(jamaica_thread *ct, jamaica_int64 arg0, jamaica_int32 arg1, jamaica_int32 arg2);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIIRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_int32 arg4, jamaica_ref arg5, jamaica_int32 arg6);
JBIEXPORT jamaica_ref JBICALL REV_STUB_RRIIRIR(jamaica_thread *ct, jamaica_ref arg0, jamaica_ref arg1, jamaica_int32 arg2, jamaica_int32 arg3, jamaica_ref arg4, jamaica_int32 arg5);
#else
#error 'jamaica.h' not found!
#endif

#ifdef __cplusplus
}
#endif

