package com.social_link_generator.social_link_generator.services;

import com.social_link_generator.social_link_generator.entities.Link;

import org.springframework.stereotype.Service;

@Service
public class LinkGeneratorService {

    public Object generateShareableLinks(String url) {
        String facebookLinkFormat = "https://www.facebook.com/sharer/sharer.php?u=[post-url]";
        String twitterLinkFormat = "https://twitter.com/share?url=[post-url]";
        String linkedinLinkFormat = "https://www.linkedin.com/shareArticle?url=[post-url]";
        String pinterestLinkFormat = "https://pinterest.com/pin/create/button/?url=[post-url]";
        String emailLinkFormat = "mailto:info@example.com?&subject=&body=[post-url]";

        String replaceString = "[post-url]";

        Link facebookLink = new Link("facebook-f", facebookLinkFormat.replace(replaceString, url), "blue");
        Link twitterLink = new Link("twitter", twitterLinkFormat.replace(replaceString, url), "aqua");
        Link linkedinLink = new Link("linkedin", linkedinLinkFormat.replace(replaceString, url), "darkblue");
        Link pinterestLink = new Link("pinterest", pinterestLinkFormat.replace(replaceString, url), "red");
        Link emailLink = new Link("envelope", emailLinkFormat.replace(replaceString, url), "gray");

        return new Object[] { facebookLink, twitterLink, linkedinLink, pinterestLink, emailLink };
    }

}