# KotLink
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://travis-ci.org/ilya40umov/KotLink.png?branch=master)](https://travis-ci.org/ilya40umov/KotLink)
[![codecov](https://codecov.io/gh/ilya40umov/KotLink/branch/master/graph/badge.svg)](https://codecov.io/gh/ilya40umov/KotLink)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1a55315857b44bb78aab3a87da4f61ec)](https://www.codacy.com/app/ilya40umov/KotLink?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ilya40umov/KotLink&amp;utm_campaign=Badge_Grade)

KotLink is a solution for creating and sharing memorable URL aliases, 
which takes its inspiration from Google's internal Go-Links system.

### Why use KotLink?

* Get rid of bookmarks for URLs frequently used within your team
* Speak the same language as your colleges (e.g. Hey, can you check out what is happening with `staging grafana`?)
* Search your "intranet" quickly for a resource that you don't know the URL for

### Overview

KotLink works by letting people install a tiny browser extension 
that activates when the person first types **go** in the address bar and then presses **space**. 
While activated, the extension is providing autocomplete based on the database of aliases,
and after the user has hit **enter**, it will redirect the user to the actual URL that matches the provided alias.

![Suggestions In Address Bar](https://raw.githubusercontent.com/ilya40umov/KotLink/master/images/suggest.png)

For example, if someone has already created an alias for `vim shortcuts` 
that maps to `https://vim.rtorr.com`,
by typing **go** `space` **vim shortcuts** `enter`, the user will be redirected to the aforementioned link.

Please, also note that to use the browser extension, you first need to set up a dedicated KotLink server
(see the instructions below).

### Get KotLink In Your Browser

Install [Firefox Extension](https://addons.mozilla.org/en-US/firefox/addon/kotlink-browser-extension)

Install [Chrome Extension](https://chrome.google.com/webstore/detail/kotlink-browser-extension/cdkflkfieefihicjaidafmggjdnkakod)

To use KotLink with Vivaldi perform the following steps:
1. Go to Settings / Privacy and enable "Search Suggestions in Address Field".
1. Go to Settings / Search and make sure "Allow Search Suggestions" is checked for "In Address Field".
1. Also in Settings / Search, add a new search engine where:
  - *Name* is `KotLink` 
  - *Nickname* is `go`
  - *URL* is `http://YOUR_SERVER_ADDRESS/api/link/redirect?link=%s`
  - *Suggest URL* is `http://YOUR_SERVER_ADDRESS/api/link/suggest?link=%s&mode=opensearch&secret=YOUR_SECRET`

### Deploy KotLink Server

KotLink server provides the backend for storing and resolving aliases, 
as well as UI for creating/editing them.

![List Aliases in UI](https://raw.githubusercontent.com/ilya40umov/KotLink/master/images/list-aliases.png)

*The installation instructions are coming soon*

### Engineering Guide
If you would like to contribute to the project, or just try it out on your local machine, 
take a look at the [Engineering Guide](ENG-GUIDE.md).