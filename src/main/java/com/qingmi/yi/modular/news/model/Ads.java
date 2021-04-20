package com.qingmi.yi.modular.news.model;

import lombok.Data;

import java.util.Arrays;

/**
 * 广告接口响应参数子元素
 */
@Data
public class Ads {

    public String adType	;//	广告交互类型 （跳转类、下载 类、品牌类），redirect/download/brand	redirect
    public String clickurl	;//	点击跳转链接
    public String deepLink	;//	否	点击跳转应用链接	深度链接，跳转到某个应用内部,如果有deeplink优先deeplink，没有就是用clickUrl
    public String [] imgurls	;//	是	广告物料数组
    public String adWidth	;//	否	宽度
    public String adHeight	;//	否	高度
    public String displayTitle	;//	广告标题
    public String displayText	;//	否	广告描述
    public String [] showFollowUrls	;//	是	展示监播数组
    public String [] clickFollowUrls	;//	是	点击监播数组
    public String [] deepLinkUrls	;//	是	Deeplink唤醒监播	当deepLink深度链接有的时候会有该监播数组
    public String videoUrl	;//	否	视频Url（广告位ID为视频广告位的时候出现）	V1.1 add
    public String videoDuration	;//	否	视频广告的时长	V1.1 add
    public String [] startDownUrls	;//	否	开始下载监播	V1.3 add
    public String [] endDownUrls	;//	否	下载完成监播	V1.3 add
    public String [] finishUrls	;//	否	播放完成监播	V1.3 add
    public String [] startInstalledUrls	;//	否	安装开始监播
    public String [] endInstalledUrls	;//	否	安装完成监播


    @Override
    public String toString() {
        return "Ads{" +
                "adType='" + adType + '\'' +
                ", clickurl='" + clickurl + '\'' +
                ", deepLink='" + deepLink + '\'' +
                ", imgurls=" + Arrays.toString(imgurls) +
                ", adWidth='" + adWidth + '\'' +
                ", adHeight='" + adHeight + '\'' +
                ", displayTitle='" + displayTitle + '\'' +
                ", displayText='" + displayText + '\'' +
                ", showFollowUrls=" + Arrays.toString(showFollowUrls) +
                ", clickFollowUrls=" + Arrays.toString(clickFollowUrls) +
                ", deepLinkUrls=" + Arrays.toString(deepLinkUrls) +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoDuration='" + videoDuration + '\'' +
                ", startDownUrls=" + Arrays.toString(startDownUrls) +
                ", endDownUrls=" + Arrays.toString(endDownUrls) +
                ", finishUrls=" + Arrays.toString(finishUrls) +
                ", startInstalledUrls=" + Arrays.toString(startInstalledUrls) +
                ", endInstalledUrls=" + Arrays.toString(endInstalledUrls) +
                '}';
    }
}
