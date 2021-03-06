/*
 * Copyright (C) 2014 Trillian Mobile AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.coremedia;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.dispatch.*;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coreanimation.*;
import org.robovm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreMedia")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMBufferQueue/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMBufferQueuePtr extends Ptr<CMBufferQueue, CMBufferQueuePtr> {}/*</ptr>*/
    
    public interface GetTimeCallback {
        CMTime getTime(CMBuffer buffer);
    }
    public interface GetBooleanCallback {
        boolean getBoolean(CMBuffer buffer);
    }
    public interface CompareCallback {
        CFComparisonResult compare(CMBuffer buffer1, CMBuffer buffer2);
    }
    public interface GetSizeCallback {
        int getSize(CMBuffer buffer);
    }
    public interface ResetCallback {
        void reset(CMBuffer buffer);
    }
    public interface TriggerCallback {
        void trigger(CMBufferQueueTriggerToken triggerToken);
    }
    public interface ValidationCallback {
        void validate(CMBufferQueue bufferQueue, CMBuffer buffer);
    }
    public interface ForEachCallback {
        CMBufferQueueError invoke(CMBuffer buffer);
    }
    
    private static java.util.concurrent.atomic.AtomicLong refconId = new java.util.concurrent.atomic.AtomicLong();
    private static java.util.concurrent.atomic.AtomicLong triggerId = new java.util.concurrent.atomic.AtomicLong();
    private static Map<Long, GetTimeCallback> getDecodeTimeStampCallbacks = new HashMap<Long, GetTimeCallback>();
    private static Map<Long, GetTimeCallback> getPresentationTimeStampCallbacks = new HashMap<Long, GetTimeCallback>();
    private static Map<Long, GetTimeCallback> getDurationCallbacks = new HashMap<Long, GetTimeCallback>();
    private static Map<Long, GetBooleanCallback> isDataReadyCallbacks = new HashMap<Long, GetBooleanCallback>();
    private static Map<Long, CompareCallback> compareCallbacks = new HashMap<Long, CompareCallback>();
    private static Map<Long, GetSizeCallback> getSizeCallbacks = new HashMap<Long, GetSizeCallback>();
    private static Map<Long, ResetCallback> resetCallbacks = new HashMap<Long, ResetCallback>();
    private static Map<Long, TriggerCallback> triggerCallbacks = new HashMap<Long, TriggerCallback>();
    private static Map<Long, ValidationCallback> validationCallbacks = new HashMap<Long, ValidationCallback>();
    private static Map<Long, ForEachCallback> forEachCallbacks = new HashMap<Long, ForEachCallback>();
    private static final java.lang.reflect.Method cbGetDecodeTimeStamp;
    private static final java.lang.reflect.Method cbGetPresentationTimeStamp;
    private static final java.lang.reflect.Method cbGetDuration;
    private static final java.lang.reflect.Method cbIsDataReady;
    private static final java.lang.reflect.Method cbCompare;
    private static final java.lang.reflect.Method cbGetSize;
    private static final java.lang.reflect.Method cbReset;
    private static final java.lang.reflect.Method cbTrigger;
    private static final java.lang.reflect.Method cbValidate;
    private static final java.lang.reflect.Method cbForEach;
    
    static {
        try {
            cbGetDecodeTimeStamp = CMBufferQueue.class.getDeclaredMethod("cbGetDecodeTimeStamp", CMBuffer.class, long.class);
            cbGetPresentationTimeStamp = CMBufferQueue.class.getDeclaredMethod("cbGetPresentationTimeStamp", CMBuffer.class, long.class);
            cbGetDuration = CMBufferQueue.class.getDeclaredMethod("cbGetDuration", CMBuffer.class, long.class);
            cbIsDataReady = CMBufferQueue.class.getDeclaredMethod("cbIsDataReady", CMBuffer.class, long.class);         
            cbCompare = CMBufferQueue.class.getDeclaredMethod("cbCompare", CMBuffer.class, CMBuffer.class, long.class);
            cbGetSize = CMBufferQueue.class.getDeclaredMethod("cbGetSize", CMBuffer.class, long.class);
            cbReset = CMBufferQueue.class.getDeclaredMethod("cbReset", CMBuffer.class, long.class);
            cbTrigger = CMBufferQueue.class.getDeclaredMethod("cbTrigger", long.class, CMBufferQueueTriggerToken.class);
            cbValidate = CMBufferQueue.class.getDeclaredMethod("cbValidate", CMBufferQueue.class, CMBuffer.class, long.class);
            cbForEach = CMBufferQueue.class.getDeclaredMethod("cbForEach", CMBuffer.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(CMBufferQueue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CMBufferQueue() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static CMTime cbGetDecodeTimeStamp(CMBuffer buffer, @Pointer long refcon) {
        GetTimeCallback callback = null;
        synchronized (getDecodeTimeStampCallbacks) {
            callback = getDecodeTimeStampCallbacks.get(refcon);
        }
        return callback.getTime(buffer);
    }
    @Callback
    private static CMTime cbGetPresentationTimeStamp(CMBuffer buffer, @Pointer long refcon) {
        GetTimeCallback callback = null;
        synchronized (getPresentationTimeStampCallbacks) {
            callback = getPresentationTimeStampCallbacks.get(refcon);
        }
        return callback.getTime(buffer);
    }
    @Callback
    private static CMTime cbGetDuration(CMBuffer buffer, @Pointer long refcon) {
        GetTimeCallback callback = null;
        synchronized (getDurationCallbacks) {
            callback = getDurationCallbacks.get(refcon);
        }
        return callback.getTime(buffer);
    }
    @Callback
    private static boolean cbIsDataReady(CMBuffer buffer, @Pointer long refcon) {
        GetBooleanCallback callback = null;
        synchronized (isDataReadyCallbacks) {
            callback = isDataReadyCallbacks.get(refcon);
        }
        return callback.getBoolean(buffer);
    }
    @Callback
    private static CFComparisonResult cbCompare(CMBuffer buffer1, CMBuffer buffer2, @Pointer long refcon) {
        CompareCallback callback = null;
        synchronized (compareCallbacks) {
            callback = compareCallbacks.get(refcon);
        }
        return callback.compare(buffer1, buffer2);
    }
    @Callback
    private static int cbGetSize(CMBuffer buffer, @Pointer long refcon) {
        GetSizeCallback callback = null;
        synchronized (getSizeCallbacks) {
            callback = getSizeCallbacks.get(refcon);
        }
        return callback.getSize(buffer);
    }
    @Callback
    private static void cbReset(CMBuffer buffer, @Pointer long refcon) {
        ResetCallback callback = null;
        synchronized (resetCallbacks) {
            callback = resetCallbacks.get(refcon);
        }
        callback.reset(buffer);
    }
    @Callback
    private static void cbTrigger(@Pointer long refcon, CMBufferQueueTriggerToken triggerToken) {
        TriggerCallback callback = null;
        synchronized (triggerCallbacks) {
            callback = triggerCallbacks.get(refcon);
        }
        callback.trigger(triggerToken);
    }
    @Callback
    private static void cbValidate(CMBufferQueue bufferQueue, CMBuffer buffer, @Pointer long refcon) {
        ValidationCallback callback = null;
        synchronized (validationCallbacks) {
            callback = validationCallbacks.get(refcon);
        }
        callback.validate(bufferQueue, buffer);
    }
    @Callback
    private static void cbForEach(CMBuffer buffer, @Pointer long refcon) {
        ForEachCallback callback = null;
        synchronized (forEachCallbacks) {
            callback = forEachCallbacks.get(refcon);
        }
        callback.invoke(buffer);
    }
    
    @Override
    protected void dispose (boolean finalizing) throws Throwable {
        synchronized (getDecodeTimeStampCallbacks) {
            getDecodeTimeStampCallbacks.clear();
            getPresentationTimeStampCallbacks.clear();
            getDurationCallbacks.clear();
            isDataReadyCallbacks.clear();
            compareCallbacks.clear();
            getSizeCallbacks.clear();
            resetCallbacks.clear();
            triggerCallbacks.clear();
            validationCallbacks.clear();
            forEachCallbacks.clear();
        }
        super.dispose(finalizing);
    }
    
    public static CMBufferQueue create(@MachineSizedSInt long capacity, GetTimeCallback getDecodeTimeStampCallback, GetTimeCallback getPresentationTimeStampCallback, GetTimeCallback getDurationCallback, GetBooleanCallback isDataReadyCallback, CompareCallback compareCallback, GetSizeCallback getSizeCallback) {
        long refconId = CMBufferQueue.refconId.getAndIncrement();
        CMBufferCallbacks callbacks = new CMBufferCallbacks();
        callbacks.refcon(refconId);
        callbacks.getDecodeTimeStamp(new FunctionPtr(cbGetDecodeTimeStamp));
        callbacks.getPresentationTimeStamp(new FunctionPtr(cbGetPresentationTimeStamp));
        callbacks.getDuration(new FunctionPtr(cbGetDuration));
        callbacks.isDataReady(new FunctionPtr(cbIsDataReady));
        callbacks.compare(new FunctionPtr(cbCompare));
        callbacks.getSize(new FunctionPtr(cbGetSize));
        CMBufferQueuePtr ptr = new CMBufferQueuePtr();
        create(null, capacity, callbacks, ptr);
        synchronized (getDecodeTimeStampCallbacks) {
            getDecodeTimeStampCallbacks.put(refconId, getDecodeTimeStampCallback);
            getPresentationTimeStampCallbacks.put(refconId, getPresentationTimeStampCallback);
            getDurationCallbacks.put(refconId, getDurationCallback);
            isDataReadyCallbacks.put(refconId, isDataReadyCallback);
            compareCallbacks.put(refconId, compareCallback);
            getSizeCallbacks.put(refconId, getSizeCallback);
        }
        return ptr.get();
    }
    
    public CMBufferQueueError reset(ResetCallback callback) {
        long refconId = CMBufferQueue.refconId.get();
        CMBufferQueueError error = reset(new FunctionPtr(cbReset), refconId);
        synchronized (resetCallbacks) {
            resetCallbacks.put(refconId, callback);
        }
        return error;
    }
    
    public CMBufferQueueError installTrigger(TriggerCallback callback, CMBufferQueueTriggerCondition triggerCondition, @ByVal CMTime triggerTime) {
        long refconId = CMBufferQueue.triggerId.getAndIncrement();
        CMBufferQueueError error = installTrigger(new FunctionPtr(cbTrigger), refconId, triggerCondition, triggerTime, null);
        synchronized (triggerCallbacks) {
            triggerCallbacks.put(refconId, callback);
        }
        return error;
    }
    
    public CMBufferQueueError installTrigger(TriggerCallback callback, CMBufferQueueTriggerCondition triggerCondition, @MachineSizedSInt long triggerThreshold) {
        long refconId = CMBufferQueue.triggerId.getAndIncrement();
        CMBufferQueueError error = installTrigger(new FunctionPtr(cbTrigger), refconId, triggerCondition, triggerThreshold, null);
        synchronized (triggerCallbacks) {
            triggerCallbacks.put(refconId, callback);
        }
        return error;
    }
    
    public CMBufferQueueError callForEachBuffer(ForEachCallback callback) {
        long refconId = CMBufferQueue.refconId.get();
        CMBufferQueueError error = callForEachBuffer(new FunctionPtr(cbReset), refconId);
        synchronized (forEachCallbacks) {
            forEachCallbacks.put(refconId, callback);
        }
        return error;
    }
    
    public CMBufferQueueError setValidationCallback(ValidationCallback callback) {
        long refconId = CMBufferQueue.refconId.get();
        CMBufferQueueError error = setValidationCallback(new FunctionPtr(cbValidate), refconId);
        synchronized (validationCallbacks) {
            validationCallbacks.put(refconId, callback);
        }
        return error;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetCallbacksForUnsortedSampleBuffers", optional=true)
    public static native CMBufferCallbacks getCallbacksForUnsortedSampleBuffers();
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Bridge(symbol="CMBufferQueueGetCallbacksForSampleBuffersSortedByOutputPTS", optional=true)
    public static native CMBufferCallbacks getCallbacksForSampleBuffersSortedByOutputPTS();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueCreate", optional=true)
    protected static native int create(CFAllocator allocator, @MachineSizedSInt long capacity, CMBufferCallbacks callbacks, CMBufferQueue.CMBufferQueuePtr queueOut);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueEnqueue", optional=true)
    public native CMBufferQueueError enqueue(CMBuffer buf);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueDequeueAndRetain", optional=true)
    public native CMBuffer dequeueAndRetain();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueDequeueIfDataReadyAndRetain", optional=true)
    public native CMBuffer dequeueIfDataReadyAndRetain();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetHead", optional=true)
    public native CMBuffer getHead();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueIsEmpty", optional=true)
    public native boolean isEmpty();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueMarkEndOfData", optional=true)
    public native CMBufferQueueError markEndOfData();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueContainsEndOfData", optional=true)
    public native boolean containsEndOfData();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueIsAtEndOfData", optional=true)
    public native boolean isAtEndOfData();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueReset", optional=true)
    public native CMBufferQueueError reset();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueResetWithCallback", optional=true)
    protected native CMBufferQueueError reset(FunctionPtr callback, @Pointer long refcon);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetBufferCount", optional=true)
    public native @MachineSizedSInt long getBufferCount();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetDuration", optional=true)
    public native @ByVal CMTime getDuration();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetMinDecodeTimeStamp", optional=true)
    public native @ByVal CMTime getMinDecodeTimeStamp();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetFirstDecodeTimeStamp", optional=true)
    public native @ByVal CMTime getFirstDecodeTimeStamp();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetMinPresentationTimeStamp", optional=true)
    public native @ByVal CMTime getMinPresentationTimeStamp();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetFirstPresentationTimeStamp", optional=true)
    public native @ByVal CMTime getFirstPresentationTimeStamp();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetMaxPresentationTimeStamp", optional=true)
    public native @ByVal CMTime getMaxPresentationTimeStamp();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueGetEndPresentationTimeStamp", optional=true)
    public native @ByVal CMTime getEndPresentationTimeStamp();
    /**
     * @since Available in iOS 7.1 and later.
     */
    @Bridge(symbol="CMBufferQueueGetTotalSize", optional=true)
    public native @MachineSizedUInt long getTotalSize();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueInstallTrigger", optional=true)
    protected native CMBufferQueueError installTrigger(FunctionPtr triggerCallback, @Pointer long triggerRefcon, CMBufferQueueTriggerCondition triggerCondition, @ByVal CMTime triggerTime, CMBufferQueueTriggerToken.CMBufferQueueTriggerTokenPtr triggerTokenOut);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueInstallTriggerWithIntegerThreshold", optional=true)
    protected native CMBufferQueueError installTrigger(FunctionPtr triggerCallback, @Pointer long triggerRefcon, CMBufferQueueTriggerCondition triggerCondition, @MachineSizedSInt long triggerThreshold, CMBufferQueueTriggerToken.CMBufferQueueTriggerTokenPtr triggerTokenOut);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueRemoveTrigger", optional=true)
    public native CMBufferQueueError removeTrigger(CMBufferQueueTriggerToken triggerToken);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueTestTrigger", optional=true)
    public native boolean testTrigger(CMBufferQueueTriggerToken triggerToken);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueCallForEachBuffer", optional=true)
    protected native CMBufferQueueError callForEachBuffer(FunctionPtr callback, @Pointer long refcon);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMBufferQueueSetValidationCallback", optional=true)
    protected native CMBufferQueueError setValidationCallback(FunctionPtr validationCallback, @Pointer long validationRefCon);
    /*</methods>*/
}
