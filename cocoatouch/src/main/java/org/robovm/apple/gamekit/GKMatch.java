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
package org.robovm.apple.gamekit;

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
import org.robovm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("GameKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GKMatch/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class GKMatchPtr extends Ptr<GKMatch, GKMatchPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GKMatch.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public GKMatch() {}
    protected GKMatch(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "playerIDs")
    public native NSArray<NSString> getPlayerIDs();
    @Property(selector = "delegate")
    public native GKMatchDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(GKMatchDelegate v);
    @Property(selector = "expectedPlayerCount")
    public native @MachineSizedUInt long getExpectedPlayerCount();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "sendData:toPlayers:withDataMode:error:")
    public native boolean sendData(NSData data, NSArray<NSString> playerIDs, GKMatchSendDataMode mode, NSError.NSErrorPtr error);
    @Method(selector = "sendDataToAllPlayers:withDataMode:error:")
    public native boolean sendDataToAllPlayers(NSData data, GKMatchSendDataMode mode, NSError.NSErrorPtr error);
    @Method(selector = "disconnect")
    public native void disconnect();
    @Method(selector = "voiceChatWithName:")
    public native GKVoiceChat getVoiceChat(String name);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "chooseBestHostPlayerWithCompletionHandler:")
    public native void chooseBestHostPlayer(@Block VoidBlock1<NSString> completionHandler);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "rematchWithCompletionHandler:")
    public native void rematch(@Block VoidBlock2<GKMatch, NSError> completionHandler);
    /*</methods>*/
}
