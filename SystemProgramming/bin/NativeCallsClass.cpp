#include <iostream>
#include "NativeCallsClass.h"

JNIEXPORT jint JNICALL Java_ru_ssau_systemprogramming_model_NativeCallsClass_inputInt(JNIEnv *, jclass, jint a, jint b){
	int c;
	asm(
	"movl %1, %%eax;movl %2, %%ebx;or %%eax, %%ebx;mov %%ebx, %0;"
	:"=r"(c)
	:"r"(a),"r"(b)
	:"%eax","%ebx"
	);
	return c;
}
