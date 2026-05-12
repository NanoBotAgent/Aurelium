# Aurelium - Patch Notes

## v1.4.5 - Paper 1.21.x Backport

**Same v1.4.5 features, adapted for Paper 1.21.4+ (Java 21).**

### Platform Changes (from 26.1 branch)
- **Java 21** instead of Java 25 (toolchain and `options.release` updated)
- **Paper API `1.21.4-R0.1-SNAPSHOT`** instead of `26.1.2.build.53-stable`
- **`api-version: '1.21'`** in plugin.yml instead of `'26.1'`
- **Enchantment lookup**: Uses `Registry.ENCHANTMENT.get(NamespacedKey.minecraft(...))` (Bukkit registry) instead of Paper's `RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT)` which is 26.1-only
- **Sweeping Edge**: Keeps original Bukkit name `SWEEPING_EDGE` (the `SWEEPING_COLLISION` rename only exists in MC 26.1+)
- CI tested against Paper 1.21.4 build 232 (build, smoke-test, ingame-test, mysql-test all pass)

### Fixes (carried from 26.1 branch)
- **MySQL 8.0.20+ Compatibility**: Replaced deprecated `VALUES(col)` syntax with modern `AS new` alias syntax in all upsert queries
- **Auction Custom Display Names**: Auction messages now show custom item display names instead of raw material types. Uses `PlainTextComponentSerializer` for safe Component handling
- **PreparedStatement Param Mismatch**: MySQL upserts now only set the parameters they actually use

### Testing
- All 4 CI jobs pass on Paper 1.21.4: build, smoke-test, ingame-test, mysql-test
- RCON-based in-game command testing (25 tests covering all commands)
- MySQL 8.0 CI test suite (10 tests) against service container
- Zero `SQLSyntaxErrorException` confirmed on MySQL 8.0

## v1.4.3 - CI & Testing Infrastructure

**Automated in-game testing ensures every command works correctly.**

### Testing
- Added RCON-based in-game command testing to GitHub Actions CI (25 tests covering all commands)
- `/bal` variants: self, other player, with currency — all verified
- `/eco` admin commands: give, take, set, with currency, invalid inputs (negative, non-numeric, missing args, invalid currency, invalid action)
- Player-only commands reject console correctly: `/pay`, `/market`, `/web`, `/stocks`, `/ah` (4 subcommands), `/orders` (4 subcommands)
- All tests pass on every push — zero regressions guaranteed

### Internal
- Bumped version to 1.4.3 across all build files and config

## v1.4.2 - Security & Performance Hardening

**This update is mandatory for all servers using the web dashboard.**

### Security
- Session tokens for the web dashboard now use cryptographically secure `SecureRandom` (256-bit entropy) instead of `UUID.randomUUID()` (122-bit), preventing potential token prediction attacks
- Added explanatory comments to `CloudSyncManager` for exceptions that are safely ignored

### Performance
- Cloud dashboard registration retries no longer block a `ForkJoinPool` thread for 15 seconds between attempts, replaced `Thread.sleep(15_000)` with Bukkit's non-blocking `runTaskLaterAsynchronously` scheduler
- Offline earnings cleanup now uses a single bulk `DELETE` SQL query instead of N+1 individual queries when a player joins, significantly reducing database load on servers with many offline earnings records

### Fixes
- Added proper exception logging to previously empty `catch` blocks in `ShopGUI` and `CloudSyncManager`, making debugging much easier
- Fixed a bug in `ShopGUI` where `target` was used instead of `clicker` for certain player interactions
- **BungeeCord/Velocity Sync**: Fixed a major bug where player balances could stay "stale" when switching servers due to permanent RAM caching. Player data is now refreshed from MySQL immediately upon joining a new server instance.

### Internal
- Bumped version in `pom.xml` to `1.4.2` to ensure consistent builds across Maven and Gradle.
- Updated `README.md` to clarify that MySQL is mandatory for cross-server synchronization and that Market Prices remain per-server for regional economy support.

## v1.4.1 - Web Stability Hotfix

### Fixes
- Cloud sync now automatically reconnects to the web dashboard if the render server restarts (Fixes 403 Invalid server ID error)

## v1.4.0 - Security, Enchantments & Cleanup

### New
- Enchantment books now have individual prices based on rarity and level (Mending = 35k, Sharpness V = 60k, etc.)
- Added 1.21.11 enchantments: Breach, Density, Wind Burst
- Web dashboard balance updates instantly after buying/selling in-game
- `/bal` now suggests currencies and online players in tab
- Auto database backups when the plugin updates
- Auto schema migrations on startup

### Fixes
- `/bal` was checking the wrong permission — non-op players couldn't use it
- SellGUI sometimes showed a different total than what you actually got paid
- Market GUI prices now update right after a transaction instead of lagging behind
- AH cancellation visual flicker on shift-click
- Collection bin no longer drops items on the ground if your inventory is full
- "All Items" button was showing items outside the configured categories
- NullPointerException when browsing "All Items"
- Cloud sync no longer spams HTML in console when the server is waking up

### Security
- Economy, market, and auction transactions are now atomic (no more duping from race conditions)
- Auction bids use price-checked SQL to prevent out-of-order bid corruption
- Web purchases are deduplicated to prevent double-spending
- All GUIs lock down shift-click and drag to prevent inventory exploits
- SellGUI locks the price at review time so it can't change mid-transaction
- CORS is now a configurable whitelist instead of wildcard

### Internal
- All money math uses BigDecimal now (no more floating point drift)
- Market item prices stored under `market-items` in config (moved from `market.items`)
- Moved Beacon, Respawn Anchor, End Crystal to proper categories
