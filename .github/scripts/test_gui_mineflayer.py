#!/usr/bin/env python3
"""In-game GUI integration test runner for Aurelium.

This script starts a Minecraft Paper server with Aurelium loaded and
runs Mineflayer bot tests against the in-game GUI interactions.
"""

import subprocess
import sys
import time
import os

def main() -> int:
    """Run GUI integration tests."""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    repo_root = os.path.dirname(script_dir)

    # Start server process (placeholder implementation)
    server_jar = os.path.join(repo_root, '..', 'paper.jar')
    if not os.path.exists(server_jar):
        print(f"Server jar not found: {server_jar}", file=sys.stderr)
        return 1

    process = subprocess.Popen(
        ['java', '-jar', server_jar, '--nogui'],
        cwd=repo_root,
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT,
        text=True
    )

    try:
        # Wait for server to start
        time.sleep(10)
        # Run mineflayer test
        result = subprocess.run(
            ['node', os.path.join(script_dir, 'test_gui_mineflayer.js')],
            capture_output=True,
            text=True
        )
        print(result.stdout)
        if result.stderr:
            print(result.stderr, file=sys.stderr)
        return result.returncode
    finally:
        process.terminate()
        process.wait()


if __name__ == '__main__':
    sys.exit(main())
