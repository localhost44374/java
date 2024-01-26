'use strict';
const MANIFEST = 'flutter-app-manifest';
const TEMP = 'flutter-temp-cache';
const CACHE_NAME = 'flutter-app-cache';

const RESOURCES = {"assets/AssetManifest.json": "3cf27ffe84308f197186b15e718e9905",
"assets/AssetManifest.smcbin": "62d490a3f861a764df6a4dea9d8cef77",
"assets/assets/ArrayUtil.java": "7a33da8e43abf92132c8900909854abb",
"assets/assets/BankAccountImpl.java": "12f5cc8311162aaabdf9d272022d0e40",
"assets/assets/BoxImpl.java": "9502ddc35eec7ffc9cb8abcbfb631985",
"assets/assets/CalculatorImpl.java": "cec6c70a3a5589b5972213401f40c1a1",
"assets/assets/CharacterFrequency.java": "46b6ac526425c68bbb2632f61b464656",
"assets/assets/circulardependency.zip": "138dae41d80ea9d5f88bb829ec303512",
"assets/assets/Collection.java": "bd3f36f99c70713fccf0347ef4f750b7",
"assets/assets/CounterUsingCookie.zip": "c4d9eeee97f10f89250710e04502cb97",
"assets/assets/EmployeeImpl.java": "7728d275f4e3148f27249c7f3049874e",
"assets/assets/FizzBuzz.java": "fd17a5823c27547953c4f27758cd44a0",
"assets/assets/jstl_project.zip": "5aeb0578de978c80fd73da74af2f22f8",
"assets/assets/LinkedList.java": "63285de1d0afaf291fdb17a8eec05ccd",
"assets/assets/LoginBean.zip": "4d8d588b3f413fc1941d1b6814bbb0f3",
"assets/assets/loginjsp.zip": "525ffe2efa18da86905e9019f470c6c9",
"assets/assets/mobileapplication.zip": "55fb071cc90c574b98d125f1c89eecd9",
"assets/assets/MultiplicationTable.zip": "78c0128fda7ff734c5651e7799092526",
"assets/assets/normalspringboot.zip": "2b4a1a5a35dd08dc8f472cfbe1cf3dcc",
"assets/assets/NumberGuesser.zip": "1c7f2e8254f0701cb95c3a60e7e76e11",
"assets/assets/PairImpl.java": "557ca38f3f63bde9a49bac429b19c19f",
"assets/assets/singerapplication.zip": "fee448f7484104fd3e427216c13d5f14",
"assets/assets/springaop.zip": "f2e9fef63e72b10b3b6280631c8774a2",
"assets/assets/springbootjdbc.zip": "10054ddebd5ec4c318dcfeff94753716",
"assets/assets/springbootmvc.zip": "0b2fc40f9f4c30f362ba1dd87f6febd6",
"assets/assets/springjdbc.zip": "7457b347d4f5ae33b6fe4d37375355b0",
"assets/assets/StackV1.java": "31ffe2b80fb052309872a87f0e9af878",
"assets/assets/StackV2.java": "8121af80898196a7f1721ee3b01e7ea9",
"assets/FontManifest.json": "dc3d03800ccca4601324923c0b1d6d57",
"assets/fonts/MaterialIcons-Regular.otf": "62ec8220af1fb03e1c20cfa38781e17e",
"assets/NOTICES": "34d3eebb2cce8b5bdc528fe2c55984d8",
"assets/packages/cupertino_icons/assets/CupertinoIcons.ttf": "57d849d738900cfd590e9adc7e208250",
"assets/shaders/ink_sparkle.frag": "f8b80e740d33eb157090be4e995febdf",
"canvaskit/canvaskit.js": "76f7d822f42397160c5dfc69cbc9b2de",
"canvaskit/canvaskit.wasm": "f48eaf57cada79163ec6dec7929486ea",
"canvaskit/chromium/canvaskit.js": "8c8392ce4a4364cbb240aa09b5652e05",
"canvaskit/chromium/canvaskit.wasm": "fc18c3010856029414b70cae1afc5cd9",
"canvaskit/skwasm.js": "1df4d741f441fa1a4d10530ced463ef8",
"canvaskit/skwasm.wasm": "6711032e17bf49924b2b001cef0d3ea3",
"canvaskit/skwasm.worker.js": "19659053a277272607529ef87acf9d8a",
"favicon.png": "5dcef449791fa27946b3d35ad8803796",
"flutter.js": "6b515e434cea20006b3ef1726d2c8894",
"icons/Icon-192.png": "ac9a721a12bbc803b44f645561ecb1e1",
"icons/Icon-512.png": "96e752610906ba2a93c65f8abe1645f1",
"icons/Icon-maskable-192.png": "c457ef57daa1d16f64b27b786ec2ea3c",
"icons/Icon-maskable-512.png": "301a7604d45b3e739efc881eb04896ea",
"index.html": "01b0cb66fe52160ecb5db38b46ff72fa",
"/": "01b0cb66fe52160ecb5db38b46ff72fa",
"main.dart.js": "bf2d2e01045b9ab6b0c797b4ed845478",
"manifest.json": "331be34f590a217052e01b432376b0d2",
"version.json": "09c4cbb54f28631e05fa5f62a31ac21d"};
// The application shell files that are downloaded before a service worker can
// start.
const CORE = ["main.dart.js",
"index.html",
"assets/AssetManifest.json",
"assets/FontManifest.json"];

// During install, the TEMP cache is populated with the application shell files.
self.addEventListener("install", (event) => {
  self.skipWaiting();
  return event.waitUntil(
    caches.open(TEMP).then((cache) => {
      return cache.addAll(
        CORE.map((value) => new Request(value, {'cache': 'reload'})));
    })
  );
});
// During activate, the cache is populated with the temp files downloaded in
// install. If this service worker is upgrading from one with a saved
// MANIFEST, then use this to retain unchanged resource files.
self.addEventListener("activate", function(event) {
  return event.waitUntil(async function() {
    try {
      var contentCache = await caches.open(CACHE_NAME);
      var tempCache = await caches.open(TEMP);
      var manifestCache = await caches.open(MANIFEST);
      var manifest = await manifestCache.match('manifest');
      // When there is no prior manifest, clear the entire cache.
      if (!manifest) {
        await caches.delete(CACHE_NAME);
        contentCache = await caches.open(CACHE_NAME);
        for (var request of await tempCache.keys()) {
          var response = await tempCache.match(request);
          await contentCache.put(request, response);
        }
        await caches.delete(TEMP);
        // Save the manifest to make future upgrades efficient.
        await manifestCache.put('manifest', new Response(JSON.stringify(RESOURCES)));
        // Claim client to enable caching on first launch
        self.clients.claim();
        return;
      }
      var oldManifest = await manifest.json();
      var origin = self.location.origin;
      for (var request of await contentCache.keys()) {
        var key = request.url.substring(origin.length + 1);
        if (key == "") {
          key = "/";
        }
        // If a resource from the old manifest is not in the new cache, or if
        // the MD5 sum has changed, delete it. Otherwise the resource is left
        // in the cache and can be reused by the new service worker.
        if (!RESOURCES[key] || RESOURCES[key] != oldManifest[key]) {
          await contentCache.delete(request);
        }
      }
      // Populate the cache with the app shell TEMP files, potentially overwriting
      // cache files preserved above.
      for (var request of await tempCache.keys()) {
        var response = await tempCache.match(request);
        await contentCache.put(request, response);
      }
      await caches.delete(TEMP);
      // Save the manifest to make future upgrades efficient.
      await manifestCache.put('manifest', new Response(JSON.stringify(RESOURCES)));
      // Claim client to enable caching on first launch
      self.clients.claim();
      return;
    } catch (err) {
      // On an unhandled exception the state of the cache cannot be guaranteed.
      console.error('Failed to upgrade service worker: ' + err);
      await caches.delete(CACHE_NAME);
      await caches.delete(TEMP);
      await caches.delete(MANIFEST);
    }
  }());
});
// The fetch handler redirects requests for RESOURCE files to the service
// worker cache.
self.addEventListener("fetch", (event) => {
  if (event.request.method !== 'GET') {
    return;
  }
  var origin = self.location.origin;
  var key = event.request.url.substring(origin.length + 1);
  // Redirect URLs to the index.html
  if (key.indexOf('?v=') != -1) {
    key = key.split('?v=')[0];
  }
  if (event.request.url == origin || event.request.url.startsWith(origin + '/#') || key == '') {
    key = '/';
  }
  // If the URL is not the RESOURCE list then return to signal that the
  // browser should take over.
  if (!RESOURCES[key]) {
    return;
  }
  // If the URL is the index.html, perform an online-first request.
  if (key == '/') {
    return onlineFirst(event);
  }
  event.respondWith(caches.open(CACHE_NAME)
    .then((cache) =>  {
      return cache.match(event.request).then((response) => {
        // Either respond with the cached resource, or perform a fetch and
        // lazily populate the cache only if the resource was successfully fetched.
        return response || fetch(event.request).then((response) => {
          if (response && Boolean(response.ok)) {
            cache.put(event.request, response.clone());
          }
          return response;
        });
      })
    })
  );
});
self.addEventListener('message', (event) => {
  // SkipWaiting can be used to immediately activate a waiting service worker.
  // This will also require a page refresh triggered by the main worker.
  if (event.data === 'skipWaiting') {
    self.skipWaiting();
    return;
  }
  if (event.data === 'downloadOffline') {
    downloadOffline();
    return;
  }
});
// Download offline will check the RESOURCES for all files not in the cache
// and populate them.
async function downloadOffline() {
  var resources = [];
  var contentCache = await caches.open(CACHE_NAME);
  var currentContent = {};
  for (var request of await contentCache.keys()) {
    var key = request.url.substring(origin.length + 1);
    if (key == "") {
      key = "/";
    }
    currentContent[key] = true;
  }
  for (var resourceKey of Object.keys(RESOURCES)) {
    if (!currentContent[resourceKey]) {
      resources.push(resourceKey);
    }
  }
  return contentCache.addAll(resources);
}
// Attempt to download the resource online before falling back to
// the offline cache.
function onlineFirst(event) {
  return event.respondWith(
    fetch(event.request).then((response) => {
      return caches.open(CACHE_NAME).then((cache) => {
        cache.put(event.request, response.clone());
        return response;
      });
    }).catch((error) => {
      return caches.open(CACHE_NAME).then((cache) => {
        return cache.match(event.request).then((response) => {
          if (response != null) {
            return response;
          }
          throw error;
        });
      });
    })
  );
}
